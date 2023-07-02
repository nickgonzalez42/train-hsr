package com.nickgonzalez.trainhsr.dao;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RouteRepository extends JpaRepository<Route, Integer> {
    Route findById(int id);
    Route findByOriginAndDestination(Station destination, Station origin);
}
