package com.artemrogov.planetarium.resolvers.query;


import com.artemrogov.planetarium.model.PlanetOutput;
import com.artemrogov.planetarium.service.command.PlanetQueryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlanetQueryResolver {

    private final PlanetQueryCommand planetQueryCommand;
    @QueryMapping(value = "planetById")
    public PlanetOutput getPlanetById(@Argument("id") Long id){
        return planetQueryCommand.getById(id);
    }

    @QueryMapping(value = "planets")
    public List<PlanetOutput> getPlanetsAll(){
        return planetQueryCommand.getAll();
    }
}
