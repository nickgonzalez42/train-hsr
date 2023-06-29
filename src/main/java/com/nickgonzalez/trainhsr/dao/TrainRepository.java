package com.nickgonzalez.trainhsr.dao;

import com.nickgonzalez.trainhsr.entity.Train;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TrainRepository extends JpaRepository<Train, Integer> {

}
