package com.artemrogov.planetarium;

import com.artemrogov.planetarium.resolvers.PlanetQueryResolver;
import com.artemrogov.planetarium.service.PlanetServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.GraphQlTest;
import org.springframework.context.annotation.Import;
import org.springframework.graphql.test.tester.GraphQlTester;

@GraphQlTest(PlanetQueryResolver.class)
public class PlanetQueryResolverTests {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void getPlanetByIdTest(){
        this.graphQlTester.document("PlanetData")
                .variable("id","100")
                .execute()
                .path("planetById")
                .matchesJson("""
                        "planetById": {
                              "id": "100",
                              "name": "Jupiter",
                              "weight": 317.8,
                              "volume": 1.321,
                              "square": 120.4
                            }
                        """);
    }
}
