package com.nickgonzalez.trainhsr.dao;

import com.nickgonzalez.trainhsr.entity.Route;
import com.nickgonzalez.trainhsr.entity.Station;
import com.nickgonzalez.trainhsr.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.*;
import java.util.Date;
import java.util.List;

public interface StationRepository extends JpaRepository<Station, Integer> {
    Station findStationById(int id);
}
