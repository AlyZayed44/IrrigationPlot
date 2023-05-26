package com.example.irrigationSystem.PlotOfLand.Service;

import com.example.irrigationSystem.PlotOfLand.Model.Alert;
import com.example.irrigationSystem.PlotOfLand.Repository.AlertRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class AlertService {
    @Autowired
    public AlertRepository alertRepository;
    public Alert createAlert(String message) {
        Alert alert = new Alert();
        alert.setMessage(message);
        alert.setTimestamp(LocalDateTime.now());
        return alertRepository.save(alert);
    }
    public List<Alert> getAllAlerts() {
        return alertRepository.findAll();
    }
}
