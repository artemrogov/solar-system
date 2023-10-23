package com.artemrogov.planetarium.resolvers;


import com.artemrogov.planetarium.dao.SimpleFluxRepository;
import com.artemrogov.planetarium.model.PlanetResponse;
import com.artemrogov.planetarium.service.PlanetService;
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
    private final PlanetService planetService;

    @SubscriptionMapping("planetSubscription")
    public Mono<List<PlanetResponse>> planetSubscription(){
        return Mono.just(planetService.getPlanets());
    }

    @SubscriptionMapping("simpleListSubscription")
    public Flux<String>simpleListSubscription(){
        return simpleFluxRepository.getStreamStrings();
    }
}
