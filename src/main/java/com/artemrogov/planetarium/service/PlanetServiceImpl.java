package com.artemrogov.planetarium.service;

import com.artemrogov.planetarium.dao.PlanetRepository;
import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.mapper.PlanetMapper;
import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;


@Service
@Slf4j
@RequiredArgsConstructor
public class PlanetServiceImpl implements PlanetService{

    private final PlanetMapper planetMapper;
    private final PlanetRepository planetRepository;

    @Override
    public Planet getPlanetById(Long id) {
        return planetRepository.findById(id).orElseThrow();
    }

    @Override
    public PlanetResponse getPlanetResponseById(Long id) {
        return planetMapper.convertToResponse(getPlanetById(id));
    }

    @Override
    public List<PlanetResponse> getPlanets() {
        return this.planetRepository.findAll()
                .stream()
                .map(planetMapper::convertToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public PlanetResponse create(PlanetInput input) {
        Planet planet = planetMapper.convertToEntity(input);
        Planet planetCreated = this.planetRepository.save(planet);
        return planetMapper.convertToResponse(planetCreated);
    }

    @Override
    public PlanetResponse update(Long id, PlanetInput input) {
        Planet planet = getPlanetById(id);
        this.planetMapper.partUpdate(input,planet);
        Planet planetUpdated = this.planetRepository.save(planet);
        return planetMapper.convertToResponse(planetUpdated);
    }

    @Override
    public void delete(Long id) {
        Planet planet = getPlanetById(id);
        this.planetRepository.delete(planet);
    }

    @Override
    public void deleteByIds(List<Long> ids) {
       if (ids.isEmpty()){
           return;
       }
       ids.forEach(this::delete);
    }
}
