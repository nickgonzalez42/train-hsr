package com.nickgonzalez.trainhsr.controller;

import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class StationRestController {
    private StationService stationService;
    public StationRestController(StationService theStationService) {
        this.stationService = theStationService;
    }
    @GetMapping("/stations")
    public List<Station> findAll() {
        return stationService.findAll();
    }
    @GetMapping("/stations/{id}")
    public Station findByStationId(@PathVariable int id) {
        return stationService.findStationById(id);
    }
    @GetMapping("/stations/{originId}/{destinationId}")
    public List<Station> findStationsFromOriginToDestination(@PathVariable int originId, @PathVariable int destinationId) {
        Station origin = stationService.findStationById(originId);
        Station destination = stationService.findStationById(destinationId);
        return stationService.findStationsFromOriginToDestination(origin, destination);
    }
}
