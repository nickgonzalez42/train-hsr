package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.StationRepository;
import com.nickgonzalez.trainhsr.entity.Station;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
