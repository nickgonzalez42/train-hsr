package com.nickgonzalez.trainhsr.rest;

import com.nickgonzalez.trainhsr.entity.Train;
import com.nickgonzalez.trainhsr.service.TrainService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrainRestController {
    private TrainService trainService;
    public TrainRestController(TrainService theTrainService) {
        trainService = theTrainService;
    }
    @GetMapping("/trains/{trainId}")
    public Train getTrains(@PathVariable int trainId) {
        return trainService.findTrainById(trainId);
    }
    @GetMapping("/trains/{originId}/{destinationId}/{date}")
    public List<List<Train>> getPlans(@PathVariable int originId, @PathVariable int destinationId, @PathVariable String date) {
        return trainService.findFromOriginToDestination();
    }
}
