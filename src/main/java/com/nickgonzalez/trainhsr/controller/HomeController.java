package com.nickgonzalez.trainhsr.controller;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.entity.Ticket;
import com.nickgonzalez.trainhsr.entity.Train;
import com.nickgonzalez.trainhsr.pojo.TicketList;
import com.nickgonzalez.trainhsr.pojo.Trip;
import com.nickgonzalez.trainhsr.pojo.TripValidator;
import com.nickgonzalez.trainhsr.service.RouteService;
import com.nickgonzalez.trainhsr.service.StationService;
import com.nickgonzalez.trainhsr.service.TicketService;
import com.nickgonzalez.trainhsr.service.TrainService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
public class HomeController {
    private TrainService trainService;
    private RouteService routeService;
    private StationService stationService;
    private TicketService ticketService;
    private TripValidator tripValidator;
    public HomeController(TrainService theTrainService, TicketService ticketService, RouteService theRouteService, StationService theStationService, TripValidator theTripValidator) {
        this.routeService = theRouteService;
        this.trainService = theTrainService;
        this.stationService = theStationService;
        this.tripValidator = theTripValidator;
        this.ticketService = ticketService;
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
    @ModelAttribute(name = "ticketList")
    public TicketList ticketList() {
        return new TicketList();
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
    public String purchase(@Valid Trip trip, BindingResult bindingResult, Errors errors, @ModelAttribute TicketList ticketList) {
        tripValidator.validate(trip, bindingResult);
        if (bindingResult.hasErrors()) {
            return "error";
        }
        for (int id : trip.getTrainIds()) {
            Ticket tempTicket = new Ticket(trip.getCustomerName(), trainService.findTrainById(id));
            Ticket ticket = ticketService.save(tempTicket);
            ticketList.addTicket(ticket);
            System.out.println(ticket.getTrain().getRoute().getOrigin().getName());
        }
        return "purchase";
    }
    
}
