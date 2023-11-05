package com.artemrogov.planetarium.graphql;

import com.artemrogov.planetarium.model.PlanetOutput;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.graphql.tester.AutoConfigureGraphQlTester;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.graphql.test.tester.GraphQlTester;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
@SpringBootTest
@AutoConfigureGraphQlTester
public class PlanetQueryResolverTests {
    @Autowired
    private GraphQlTester graphQlTester;

    @Test
    void getPlanetByIdTest(){
        this.graphQlTester.document("""
                        query planet($id: ID!) {
                            planetById(id: $id) {
                                name
                            }
                        }
                        """)
                .variable("id","100")
                .execute().path("planetById.name")
                .entity(String.class).isEqualTo("Jupiter");
    }

    @Test
    void getPlanetByIdFullMatchesJsonDoc(){
        PlanetOutput planetOutput = this.graphQlTester.document("""
                query planet($id: ID!) {
                            planetById(id: $id) {
                                id
                                name
                                weight
                                square
                                volume
                            }
                        }
                """)
                .variable("id","100")
                .execute()
                .path("data.planetById")
                .entity(PlanetOutput.class)
                .get();

        assertThat(planetOutput.getName()).isEqualTo("Jupiter");
        assertThat(planetOutput.getId()).isEqualTo(100);
        assertThat(planetOutput.getVolume()).isEqualTo(1.321);
        assertThat(planetOutput.getWeight()).isEqualTo(317.8);
        assertThat(planetOutput.getSquare()).isEqualTo(120.4);
    }

    @Test
    void getPlanetsList(){
        List<PlanetOutput> planets = this.graphQlTester
                .document("""
                        query planetsList{
                                  planets{
                                    id
                                    name
                                    weight
                                    square
                                    volume
                                  }
                                }
                        """)
                .execute()
                .path("data.planets[*]")
                .entityList(PlanetOutput.class)
                .get();

        Assertions.assertFalse(planets.isEmpty());
        Assertions.assertNotNull(planets.get(0).getId());
        Assertions.assertNotNull(planets.get(0).getName());

    }
}
