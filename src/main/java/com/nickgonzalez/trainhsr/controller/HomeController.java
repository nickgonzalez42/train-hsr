package com.nickgonzalez.trainhsr.controller;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.entity.Train;
import com.nickgonzalez.trainhsr.pojo.Trip;
import com.nickgonzalez.trainhsr.service.RouteService;
import com.nickgonzalez.trainhsr.service.StationService;
import com.nickgonzalez.trainhsr.service.TrainService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HomeController {
    private TrainService trainService;
    private RouteService routeService;
    private StationService stationService;
    public HomeController(TrainService theTrainService, RouteService theRouteService, StationService theStationService) {
        this.routeService = theRouteService;
        this.trainService = theTrainService;
        this.stationService = theStationService;
    }
    @ModelAttribute(name = "stations")
    public List<Station> stations() {
        List<Station> stations = stationService.findAll();
        Collections.sort(stations, Comparator.comparing(Station::getName));
        return stations;
    }
    @ModelAttribute(name = "trip")
    public Trip trip() {
        return new Trip();
    }
    @GetMapping("/")
    public String home() {
        return "home";
    }

    @GetMapping("/map")
    public String pickOriginAndDestination() {
        return "map";
    }
    @GetMapping("/options")
    public String getTrainSchedule(
            @RequestParam("outbound") int outbound,
            @RequestParam("inbound") int inbound,
            @RequestParam("departure-date") String departureDate,
            Model model
    ) {
        Station origin = this.stationService.findStationById(outbound);
        Station destination = this.stationService.findStationById(inbound);
        List<Station> stations = this.stationService.findStationsFromOriginToDestination(origin, destination);
        List<Route> routes = this.routeService.findRoutesFromOriginToDestination(stations);
        Date date1 = null;
        try {
            date1 = new SimpleDateFormat("yyyy-MM-dd").parse(departureDate);
            List<List<Train>> tempTrains = trainService.findListsOfTrainsInRoutes(routes, date1);
            model.addAttribute("trains", tempTrains);
            return "options";
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    @PostMapping("/purchase")
    public String purchase(Trip trip) {
        for (int id : trip.getTrainIds()) {
            System.out.println(id);
        }
        return "purchase";
    }
}
