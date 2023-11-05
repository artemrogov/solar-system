package com.artemrogov.planetarium.service.impl;


import com.artemrogov.planetarium.dao.PlanetRepository;
import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.mapper.PlanetMapper;
import com.artemrogov.planetarium.model.PlanetResponse;
import com.artemrogov.planetarium.service.command.PlanetQueryCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlanetQueryCommandImpl implements PlanetQueryCommand {

    private final PlanetMapper planetMapper;
    private final PlanetRepository planetRepository;

    public Planet getPlanetById(Long id) {
        return planetRepository.findById(id).orElseThrow();
    }
    @Override
    public PlanetResponse getById(Long id) {
        return planetMapper.convertToResponse(getPlanetById(id));
    }

    @Override
    public List<PlanetResponse> getAll() {
        return this.planetRepository.findAll()
                .stream()
                .map(planetMapper::convertToResponse)
                .collect(Collectors.toList());
    }
}
