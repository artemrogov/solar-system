package com.artemrogov.planetarium.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PlanetInput {

    private String name;

    private String description;

    private Double weight;

    private Double volume;

    private Double square;
}
