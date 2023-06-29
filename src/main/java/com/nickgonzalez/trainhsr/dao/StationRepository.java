package com.nickgonzalez.trainhsr.dao;

import com.nickgonzalez.trainhsr.entity.Station;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationRepository extends JpaRepository<Station, Integer> {
    Station findStationById(int id);
}
