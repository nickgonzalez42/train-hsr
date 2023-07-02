package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.entity.Train;

import java.util.Date;
import java.util.List;

public interface TrainService {
    public List<Train> findAll();
    public List<List<Train>> findFromOriginToDestination();
    public Train findTrainById(int id);
    public List<List<Train>> findListsOfTrainsInRoutes(List<Route> routes, Date date);
}
