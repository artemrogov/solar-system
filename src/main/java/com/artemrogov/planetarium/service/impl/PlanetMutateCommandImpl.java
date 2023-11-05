package com.artemrogov.planetarium.service.impl;

import com.artemrogov.planetarium.dao.PlanetRepository;
import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.mapper.PlanetMapper;
import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetResponse;
import com.artemrogov.planetarium.service.command.PlanetMutateCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class PlanetMutateCommandImpl implements PlanetMutateCommand {

    private final PlanetRepository planetRepository;
    private final PlanetMapper planetMapper;

    @Override
    public PlanetResponse create(PlanetInput planetInput) {
        Planet planet = planetMapper.convertToEntity(planetInput);
        Planet planetCreated = this.planetRepository.save(planet);
        return planetMapper.convertToResponse(planetCreated);
    }

    @Override
    public PlanetResponse update(Long id, PlanetInput planetInput) {
        Planet planet = planetRepository.findById(id).orElseThrow();
        this.planetMapper.partUpdate(planetInput,planet);
        Planet planetUpdated = this.planetRepository.save(planet);
        return planetMapper.convertToResponse(planetUpdated);
    }

    @Override
    public void destroy(Long id) {
        Planet planet = planetRepository.findById(id).orElseThrow();
        this.planetRepository.delete(planet);
    }

    @Override
    public void destroyByIds(List<Long> ids) {
        if (ids.isEmpty()){
            return;
        }
        ids.forEach(this::destroy);
    }
}
