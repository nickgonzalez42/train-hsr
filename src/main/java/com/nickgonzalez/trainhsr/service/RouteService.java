package com.nickgonzalez.trainhsr.service;
import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;

import java.util.List;

public interface RouteService {
    public List<Route> findAll();
    Route findById(int id);
}
