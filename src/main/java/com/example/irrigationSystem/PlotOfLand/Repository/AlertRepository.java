package com.example.irrigationSystem.PlotOfLand.Repository;

import com.example.irrigationSystem.PlotOfLand.Model.Alert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlertRepository extends JpaRepository<Alert,Long> {
}
