package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.StationRepository;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.helper.Pathfinder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StationServiceImpl implements StationService {
    private StationRepository stationRepository;
    @Autowired
    public StationServiceImpl(StationRepository theStationRepository) {
        this.stationRepository = theStationRepository;
    }
    @Override
    public List<Station> findAll() {
        return stationRepository.findAll();
    }
    @Override
    public Station findStationById(int id) {
        return stationRepository.findStationById(id);
    }
    @Override
    public List<Station> findStationsFromOriginToDestination(Station origin, Station destination) {
        Pathfinder pathfinder = new Pathfinder();
        return pathfinder.findStationsFromOriginToDestination(origin, destination);
    }

}
