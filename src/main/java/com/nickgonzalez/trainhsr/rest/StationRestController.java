package com.nickgonzalez.trainhsr.rest;

import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
//@RequestMapping("/stations")
public class StationRestController {
    private StationService stationService;
    public StationRestController(StationService theStationService) {
        stationService = theStationService;
    }
    @GetMapping("/stations")
    public List<Station> findAll() {
        return stationService.findAll();
    }
    @GetMapping("/stations/{id}")
    public Station findByStationId(@PathVariable int id) {
        return stationService.findStationById(id);
    }
}
