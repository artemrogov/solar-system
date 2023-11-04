package com.artemrogov.planetarium.command;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePlanetCommand {
    private Long planetId;
    private String name;
    private String description;
    private Double weight;
    private Double volume;
    private Double square;
}
