package com.nickgonzalez.trainhsr.rest;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.service.RouteService;
import com.nickgonzalez.trainhsr.service.StationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RouteRestController {
    private RouteService routeService;

    public RouteRestController(RouteService theRouteService) {
        routeService = theRouteService;
    }
    @GetMapping("/routes")
    public List<Route> findAll() {
        return routeService.findAll();
    }
}
