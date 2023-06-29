package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.StationRepository;
import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;

@Service
public class StationServiceImpl implements StationService {
    private StationRepository stationRepository;
    @Autowired
    public StationServiceImpl(StationRepository theStationRepository) {
        stationRepository = theStationRepository;
    }
    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
    @Override
    public Station findStationById(int id) {
        Station station = stationRepository.findStationById(id);
        List<Route> routes = station.getOutbound();
        routes.isEmpty();
        Route route = routes.get(1);
        System.out.println(route.getDistance());
        return station;
    }
}
