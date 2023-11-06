package com.artemrogov.planetarium.command;


import com.artemrogov.planetarium.dao.PlanetRepository;
import com.artemrogov.planetarium.domain.Planet;
import com.artemrogov.planetarium.mapper.PlanetMapper;
import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.service.impl.PlanetMutateCommandImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PlanetMutateCommandTests {

    @Mock
    PlanetRepository planetRepository;

    @Mock
    PlanetMapper planetMapper;

    @InjectMocks
    PlanetMutateCommandImpl planetMutateCommand;

    @Test
    void create(){
        PlanetInput planetInput = PlanetInput.builder()
                .name("Test 1")
                .description("Test 1 text")
                .square(400.3)
                .weight(1200.2)
                .volume(3422.12)
                .build();
        Planet planet = planetMapper.convertToEntity(planetInput);
        planetMutateCommand.create(planetInput);
        verify(planetRepository,times(1)).save(planet);
    }
}
