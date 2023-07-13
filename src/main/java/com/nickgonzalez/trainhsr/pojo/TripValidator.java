package com.nickgonzalez.trainhsr.pojo;

import com.nickgonzalez.trainhsr.dao.TrainRepository;
import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
public class TripValidator implements Validator {

    private final TrainRepository trainRepository;

    @Autowired
    public TripValidator(TrainRepository trainRepository) {
        this.trainRepository = trainRepository;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return Trip.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Trip trip = (Trip) target;
        List<Integer> trainIds = trip.getTrainIds();

        Set<Route> uniqueRoutes = new HashSet<>();

        for (int trainId : trainIds) {
            Train train = trainRepository.findTrainById(trainId);

            if (train == null) {
                errors.rejectValue("trainIds", "invalid.trainId", "Invalid Train ID");
                return;
            }

            Route route = train.getRoute();
            if (uniqueRoutes.contains(route)) {
                errors.rejectValue("trainIds", "duplicate.route", "Duplicate Route");
                return;
            }

            uniqueRoutes.add(route);
        }
    }
}