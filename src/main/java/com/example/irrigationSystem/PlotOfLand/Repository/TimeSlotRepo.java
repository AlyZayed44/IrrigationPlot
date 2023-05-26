package com.example.irrigationSystem.PlotOfLand.Repository;

import com.example.irrigationSystem.PlotOfLand.Model.TimeSlot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TimeSlotRepo extends JpaRepository<TimeSlot,Long> {
}
