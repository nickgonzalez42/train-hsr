package com.nickgonzalez.trainhsr.dao;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TrainRepository extends JpaRepository<Train, Integer> {
    Train findTrainById(int id);
    List<Train> findByRouteAndId(Route route, int id);
    List<Train> findByRouteAndDepartureAfter(Route route, Date departure);
//    @Query("SELECT t.* FROM trains t INNER JOIN routes r ON t.route_id = r.id WHERE t.route_id = 5 AND TIME(t.departure_time) >= '12:00:00';")
//    List<Train> findTrainsFromRouteAtOrAfterDate(Date date, Route route);
}
