package com.artemrogov.planetarium.resolvers.subscription;


import com.artemrogov.planetarium.dao.SimpleFluxRepository;
import com.artemrogov.planetarium.model.PlanetOutput;
import com.artemrogov.planetarium.service.command.PlanetQueryCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.graphql.data.method.annotation.SubscriptionMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import java.util.List;

@Controller
@RequiredArgsConstructor
public class SimpleSubscriptionQueryResolver {

    private final SimpleFluxRepository simpleFluxRepository;
    private final PlanetQueryCommand planetQueryCommand;

    @SubscriptionMapping("planetSubscription")
    public Mono<List<PlanetOutput>> planetSubscription(){
        return Mono.just(planetQueryCommand.getAll());
    }

    @SubscriptionMapping("simpleListSubscription")
    public Flux<String>simpleListSubscription(){
        return simpleFluxRepository.getStreamStrings();
    }
}
