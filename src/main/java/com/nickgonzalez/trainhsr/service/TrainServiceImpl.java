package com.nickgonzalez.trainhsr.service;

import com.nickgonzalez.trainhsr.dao.StationRepository;
import com.nickgonzalez.trainhsr.dao.TrainRepository;
import com.nickgonzalez.trainhsr.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TrainServiceImpl implements TrainService {
    private TrainRepository trainRepository;

    @Autowired
    public TrainServiceImpl(TrainRepository theTrainRepository) {
        trainRepository = theTrainRepository;
    }

    @Override
    public List<Train> findAll() {
        return trainRepository.findAll();
    }

    @Override
    public List<List<Train>> findFromOriginToDestination() {
        return null;
    }
}
