package com.artemrogov.planetarium.service.command;

import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetOutput;

import java.util.List;

public interface PlanetMutateCommand {
    PlanetOutput create(PlanetInput planetInput);
    PlanetOutput update(Long id, PlanetInput planetInput);
    void destroy(Long id);

    void destroyByIds(List<Long> ids);
}
