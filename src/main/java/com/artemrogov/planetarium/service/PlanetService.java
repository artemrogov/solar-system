package com.artemrogov.planetarium.service;

import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetResponse;

import java.util.List;

public interface PlanetService {
    Planet getPlanetById(Long id);
    PlanetResponse getPlanetResponseById(Long id);
    List<PlanetResponse> getPlanets();
    PlanetResponse create(PlanetInput input);
    PlanetResponse update(Long id, PlanetInput input);
    void delete(Long id);

    void deleteByIds(List<Long> ids);
}
