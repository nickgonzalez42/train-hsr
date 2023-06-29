package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.RouteRepository;
import com.nickgonzalez.trainhsr.dao.StationRepository;
import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RouteServiceImpl implements RouteService{

    private RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository theRouteRepository) {
        routeRepository = theRouteRepository;
    }
    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public List<Route> findByOrigin(Station station) {
        return routeRepository.findByOrigin(station);
    }
}
