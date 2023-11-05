package com.artemrogov.planetarium.service.command;

import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetResponse;

import java.util.List;

public interface PlanetMutateCommand {
    PlanetResponse create(PlanetInput planetInput);
    PlanetResponse update(Long id, PlanetInput planetInput);
    void destroy(Long id);

    void destroyByIds(List<Long> ids);
}
