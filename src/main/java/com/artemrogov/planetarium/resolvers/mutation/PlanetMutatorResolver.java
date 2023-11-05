package com.artemrogov.planetarium.resolvers.mutation;


import com.artemrogov.planetarium.model.PlanetInput;
import com.artemrogov.planetarium.model.PlanetOutput;
import com.artemrogov.planetarium.service.command.PlanetMutateCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class PlanetMutatorResolver {

    private final PlanetMutateCommand planetMutateCommand;

    @MutationMapping(name = "createPlanet")
    public PlanetOutput create(@Argument(name = "planetInput") PlanetInput input){
        return planetMutateCommand.create(input);
    }

    @MutationMapping(name = "editPlanet")
    public PlanetOutput update(@Argument(name = "id") Long id,
                               @Argument(name = "planetUpdatedInput") PlanetInput input){
        return planetMutateCommand.update(id,input);
    }

    @MutationMapping(name = "destroyPlanet")
    public void delete(@Argument Long id){
        planetMutateCommand.destroy(id);
    }


    @MutationMapping(name = "destroyByIdsPlanets")
    public void deleteByIds(@Argument List<Long> ids){
        planetMutateCommand.destroyByIds(ids);
    }
}
