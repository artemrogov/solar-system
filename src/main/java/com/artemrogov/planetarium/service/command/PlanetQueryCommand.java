package com.artemrogov.planetarium.service.command;

import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.model.PlanetResponse;

import java.util.List;

public interface PlanetQueryCommand {

    Planet getPlanetById(Long id);
    PlanetResponse getById(Long id);
    List<PlanetResponse> getAll();
}
