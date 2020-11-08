package org.SEP4_Data.service;

import lombok.val;
import org.SEP4_Data.service.model.Measurements;
import org.SEP4_Data.service.repository.MeasurementRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MeasurementService {

    @Autowired
    private MeasurementRepo repository;

    public Measurements getCurrentMeasurements(){
        Measurements current = repository.findTopByOrderByIdDesc();

        return current;
    }

}
