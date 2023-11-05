package com.artemrogov.planetarium.service.command;

import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.model.PlanetOutput;

import java.util.List;

public interface PlanetQueryCommand {

    Planet getPlanetById(Long id);
    PlanetOutput getById(Long id);
    List<PlanetOutput> getAll();
}
