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
    //TODO Change this run query param for ON or after
    List<Train> findFirst10ByRouteAndDepartureAfter(Route route, Date departure);
}
