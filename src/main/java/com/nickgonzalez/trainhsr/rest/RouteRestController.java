package com.nickgonzalez.trainhsr.rest;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.service.RouteService;
import com.nickgonzalez.trainhsr.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteRestController {
    private RouteService routeService;
    private StationService stationService;

    public RouteRestController(RouteService theRouteService, StationService theStationService) {
        routeService = theRouteService;
        stationService = theStationService;
    }
    @GetMapping("/routes")
    public List<Route> findAll() {
        return routeService.findAll();
    }
    @GetMapping("/routes/{id}")
    public Route findAll(@PathVariable int id) {
        return routeService.findById(id);
    }
    @GetMapping("/routes/tester")
    public String test() {
        return "test";
    }
}
