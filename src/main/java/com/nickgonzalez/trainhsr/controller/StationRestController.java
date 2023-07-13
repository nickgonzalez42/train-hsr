package com.nickgonzalez.trainhsr.controller;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.service.RouteService;
import com.nickgonzalez.trainhsr.service.StationService;
import com.nickgonzalez.trainhsr.service.TrainService;
import org.springframework.stereotype.Controller;
import com.nickgonzalez.trainhsr.entity.Train;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
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
}
