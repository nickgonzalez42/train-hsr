package com.nickgonzalez.trainhsr.controller;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.entity.Train;
import com.nickgonzalez.trainhsr.service.RouteService;
import com.nickgonzalez.trainhsr.service.StationService;
import com.nickgonzalez.trainhsr.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class TrainRestController {
    private TrainService trainService;
    private RouteService routeService;
    private StationService stationService;
    public TrainRestController(TrainService theTrainService, RouteService theRouteService, StationService theStationService) {
        this.routeService = theRouteService;
        this.trainService = theTrainService;
        this.stationService = theStationService;
    }
    @GetMapping("/trains/{trainId}")
    public Train getTrains(@PathVariable int trainId) {
        return trainService.findTrainById(trainId);
    }
    @GetMapping("/trains/{originId}/{destinationId}/{date}")
    public List<List<Train>> getPlans(@PathVariable int originId, @PathVariable int destinationId, @PathVariable String date) {
        Station origin = stationService.findStationById(originId);
        Station destination = stationService.findStationById(destinationId);
        List<Station> stations = stationService.findStationsFromOriginToDestination(origin, destination);
        List<Route> routes = routeService.findRoutesFromOriginToDestination(stations);
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("dd-MM-yyyy").parse(date);
            return trainService.findListsOfTrainsInRoutes(routes, date1);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
}
