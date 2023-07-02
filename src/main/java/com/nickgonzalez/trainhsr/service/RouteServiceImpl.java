package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.RouteRepository;
import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class RouteServiceImpl implements RouteService{

    private RouteRepository routeRepository;

    @Autowired
    public RouteServiceImpl(RouteRepository theRouteRepository) {
        this.routeRepository = theRouteRepository;
    }
    @Override
    public List<Route> findAll() {
        return routeRepository.findAll();
    }

    @Override
    public Route findById(int id) {
        Route route = routeRepository.findById(id);
        System.out.println(route.getDistance());
        return routeRepository.findById(id);
    }

    @Override
    public List<Route> findRoutesFromOriginToDestination(List<Station> stations) {
        List<Route> routes = new ArrayList<>();
        for(int i = 1; i < stations.size(); i++) {

            Route route = routeRepository.findByOriginAndDestination(stations.get(i - 1), stations.get(i));
            routes.add(route);
        }
        return routes;
    }
}
