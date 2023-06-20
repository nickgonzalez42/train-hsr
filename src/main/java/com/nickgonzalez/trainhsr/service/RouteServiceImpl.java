package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.RouteRepository;
import com.nickgonzalez.trainhsr.dao.StationRepository;
import com.nickgonzalez.trainhsr.entity.Route;
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
}
