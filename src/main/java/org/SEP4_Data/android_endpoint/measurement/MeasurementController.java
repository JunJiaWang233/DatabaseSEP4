package org.SEP4_Data.android_endpoint.measurement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.time.LocalTime;

@RestController
public class MeasurementController {

    @GetMapping("/current")
    public MeasurementDTO getMeasurement(){
        MeasurementDTO currentM= new MeasurementDTO();

        currentM.setId(1);
        currentM.setId_device(001);
        currentM.setDate(LocalDate.of(2020, 05,01));
        currentM.setTime(LocalTime.of(7,15));
        currentM.setLight(true);
        currentM.setTemperature(28);
        currentM.setHumidity(100);
        currentM.setCo2(67);

        return currentM;
    }
}
