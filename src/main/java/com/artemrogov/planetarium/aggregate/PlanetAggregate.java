package com.artemrogov.planetarium.aggregate;

import com.artemrogov.planetarium.command.CreatePlanetCommand;
import com.artemrogov.planetarium.command.UpdatePlanetCommand;
import com.artemrogov.planetarium.dao.PlanetRepository;
import com.artemrogov.planetarium.domain.Planet;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PlanetAggregate {

    private final PlanetRepository planetRepository;

    public Planet handleCreate(CreatePlanetCommand createCommand){
        return new Planet();
    }

    public Planet handleUpdate(UpdatePlanetCommand updateCommand){
        return new Planet();
    }
}
