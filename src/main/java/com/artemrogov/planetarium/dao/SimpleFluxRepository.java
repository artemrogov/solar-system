package com.artemrogov.planetarium.dao;

import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Repository
public class SimpleFluxRepository {
   public Flux<String> getStreamStrings(){
       return Mono.delay(Duration.ofMillis(50))
               .flatMapMany(str->Flux.just("T1","T2","T3","T4","T5","T6"));
   }
}
