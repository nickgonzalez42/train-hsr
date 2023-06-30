package com.nickgonzalez.trainhsr;

import com.nickgonzalez.trainhsr.dao.RouteRepository;
import com.nickgonzalez.trainhsr.dao.StationRepository;
import com.nickgonzalez.trainhsr.dao.TrainRepository;
import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.entity.Train;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAUnitTest {
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    StationRepository stationRepository;
    @Autowired
    TrainRepository trainRepository;
    @Autowired
    RouteRepository routeRepository;

    @Test
    public void should_find_no_objects_if_repository_is_empty() {
        Iterable stations = stationRepository.findAll();
        Iterable trains = trainRepository.findAll();
        Iterable routes = routeRepository.findAll();

        assertThat(stations).isEmpty();
        assertThat(trains).isEmpty();
        assertThat(routes).isEmpty();
    }

    @Test
    public void should_store_station_route_and_trains() {
        //Tests relationships between Stations, Routes, and Trains
        //Initialize Objects
        Station station1 = stationRepository.save(new Station(1, "Test", "TST", "1234 Test Ave", "Testville", "Illinois", "60601", 11.00, 11.00, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, null));
        Station station2 = stationRepository.save(new Station(2, "Test", "TST", "1234 Test Ave", "Testville", "Illinois", "60601", 11.00, 11.00, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, null));
        Route route1 = routeRepository.save(new Route(1, station1, station2, 178, new ArrayList<>()));
        Route route2 = routeRepository.save(new Route(2, station2, station1, 178, new ArrayList<>()));
        Train train1 = trainRepository.save(new Train(route1, new Date(2023, 11, 11, 11, 11, 11), new Date(2023, 12, 12, 12, 12, 12), 100, 101));

        //Establish Station-Route relationships
        List<Route> route1List = new ArrayList<>();
        route1List.add(route1);
        List<Route> route2List = new ArrayList<>();
        route1List.add(route2);
        station1.setOutbound(route1List);
        station1.setInbound(route2List);

        //Establish Route-Train relationship
        List<Train> trainList = new ArrayList<>();
        trainList.add(train1);
        route1.setTrain(trainList);


        assertThat(station1).hasFieldOrPropertyWithValue("id", 1);
        assertThat(station1).hasFieldOrPropertyWithValue("name", "Test");
        assertThat(station1).hasFieldOrPropertyWithValue("code", "TST");
        assertThat(station1).hasFieldOrPropertyWithValue("address", "1234 Test Ave");
        assertThat(station1).hasFieldOrPropertyWithValue("city", "Testville");
        assertThat(station1).hasFieldOrPropertyWithValue("state", "Illinois");
        assertThat(station1).hasFieldOrPropertyWithValue("zip", "60601");
        assertThat(station1).hasFieldOrPropertyWithValue("outbound", route1List);

        assertThat(route1).hasFieldOrPropertyWithValue("id", 1);
        assertThat(route1).hasFieldOrPropertyWithValue("distance", 178.0f);
        assertThat(route1).hasFieldOrPropertyWithValue("origin", station1);
        assertThat(route1).hasFieldOrPropertyWithValue("destination", station2);
        assertThat(route1).hasFieldOrPropertyWithValue("origin", station1);
        assertThat(route1).hasFieldOrPropertyWithValue("train", trainList);

        assertThat(train1).hasFieldOrProperty("id");
        assertThat(train1).hasFieldOrPropertyWithValue("departure", new Date(2023, 11, 11, 11, 11, 11));
        assertThat(train1).hasFieldOrPropertyWithValue("arrival", new Date(2023, 12, 12, 12, 12, 12));
        assertThat(train1).hasFieldOrPropertyWithValue("currentCapacity", 100);
        assertThat(train1).hasFieldOrPropertyWithValue("maxCapacity", 101);
        assertThat(train1).hasFieldOrPropertyWithValue("route", route1);
    }

    @Test
    public void should_find_all_stations() {
        Station station1 = new Station(1, "Test", "TST", "1234 Test Ave", "Testville", "Illinois", "60601", 11.00, 11.00, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, null);
        entityManager.persist(station1);

        Station station2 = new Station(2, "Test", "TST", "1234 Test Ave", "Testville", "Illinois", "60601", 11.00, 11.00, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, null);
        entityManager.persist(station2);

        Station station3 = new Station(3, "Test", "TST", "1234 Test Ave", "Testville", "Illinois", "60601", 11.00, 11.00, new ArrayList<>(), new ArrayList<>(), 0, 0, 0, null);
        entityManager.persist(station3);

        Iterable tutorials = stationRepository.findAll();

        assertThat(tutorials).hasSize(3).contains(station1, station2, station3);
    }
}
