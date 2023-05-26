package com.example.irrigationSystem.PlotOfLand.Service;

import com.example.irrigationSystem.PlotOfLand.Model.SensorData;
import org.mockito.Mockito;
import org.springframework.stereotype.Service;

@Service
public class SensorService {
    private final AlertService alertService;
    private int retryCount;
    private static final int MAX_RETRY_TIMES = 3;

    public SensorService(AlertService alertService) {
        this.alertService = alertService;
        this.retryCount = 0;
    }

    public void processSensorData() {
        try {
            // Simulating the behavior of fetching sensor data
            SensorData sensorData = fetchSensorData();

            // If sensor data is not available, create an alert
            if (sensorData == null) {
                alertService.createAlert("Sensor data not available");
            }

            // Retry logic
            if (retryCount < MAX_RETRY_TIMES && sensorData == null) {
                retryCount++;
                processSensorData(); // Retry the sensor request
            } else if (retryCount >= MAX_RETRY_TIMES) {
                alertService.createAlert("Exceeded retry times for sensor");
            }
        } catch (Exception e) {
            alertService.createAlert("Exception occurred while processing sensor data");
        }
    }

    private SensorData fetchSensorData() {
        // Simulating the behavior of fetching sensor data
        // Here, you can create a mock object using Mockito
        SensorData sensorDataMock = Mockito.mock(SensorData.class);
        // Define the behavior of the mock object
        Mockito.when(sensorDataMock.getSoilMoisture()).thenReturn(0.5);
        Mockito.when(sensorDataMock.getTemperature()).thenReturn(25.0);
        // Return the mock object
        return sensorDataMock;
    }
}


