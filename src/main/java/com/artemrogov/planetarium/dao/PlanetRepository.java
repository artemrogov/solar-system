package com.artemrogov.planetarium.dao;

import com.artemrogov.planetarium.domain.Planet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanetRepository extends JpaRepository<Planet,Long> {
}
