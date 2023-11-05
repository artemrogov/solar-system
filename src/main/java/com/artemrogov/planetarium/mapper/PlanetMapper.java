package com.artemrogov.planetarium.mapper;

import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetOutput;
import org.springframework.stereotype.Component;


@Component
public class PlanetMapper {

    public PlanetOutput convertToResponse(Planet planet){
        return PlanetOutput.builder()
                .id(planet.getId())
                .name(planet.getName())
                .square(planet.getSquare())
                .description(planet.getDescription())
                .volume(planet.getVolume())
                .weight(planet.getWeight())
                .build();
    }
    public Planet convertToEntity(PlanetInput input){
        Planet planet = new Planet();
        planet.setName(input.getName());
        planet.setDescription(input.getDescription());
        planet.setWeight(input.getWeight());
        planet.setVolume(input.getVolume());
        planet.setSquare(input.getSquare());
        return planet;
    }

    public void partUpdate(PlanetInput input, Planet planet){
        if (input.getName()!=null){
            planet.setName(input.getName());
        }
        if (input.getDescription()!=null){
            planet.setDescription(input.getDescription());
        }
        if (input.getWeight()!=null){
            planet.setWeight(input.getWeight());
        }
        if (input.getVolume()!=null){
            planet.setVolume(input.getVolume());
        }
        if (input.getSquare()!=null){
            planet.setSquare(input.getSquare());
        }
    }
}
