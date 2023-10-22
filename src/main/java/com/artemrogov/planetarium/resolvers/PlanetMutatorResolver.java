package com.artemrogov.planetarium.resolvers;


import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetResponse;
import com.artemrogov.planetarium.service.PlanetService;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlanetMutatorResolver {

    private final PlanetService planetService;

    @MutationMapping(name = "createPlanet")
    public PlanetResponse create(@Argument(name = "planetInput") PlanetInput input){
        return planetService.create(input);
    }

    @MutationMapping(name = "editPlanet")
    public PlanetResponse update(@Argument(name = "id") Long id,
                                 @Argument(name = "planetUpdatedInput") PlanetInput input){
        return planetService.update(id,input);
    }

    @MutationMapping(name = "destroyPlanet")
    public void delete(@Argument Long id){
        planetService.delete(id);
    }


    @MutationMapping(name = "destroyByIdsPlanets")
    public void deleteByIds(@Argument List<Long> ids){
        planetService.deleteByIds(ids);
    }
}
