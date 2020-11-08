package org.SEP4_Data.service.repository;

import org.SEP4_Data.service.model.Measurements;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Repository;

@Repository
public interface MeasurementRepo extends JpaRepository<Measurements, Long> {

    Measurements findTopByOrderByIdDesc();
}
