package com.example.irrigationSystem.PlotOfLand.Service;

import com.example.irrigationSystem.PlotOfLand.Model.TimeSlot;
import com.example.irrigationSystem.PlotOfLand.NotFoundException;
import com.example.irrigationSystem.PlotOfLand.Repository.TimeSlotRepo;
import com.example.irrigationSystem.PlotOfLand.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Service
public class IrrigationService {
    @Autowired
    TimeSlotRepo timeSlotRepo;

   private final ScheduledExecutorService executorService;

    public IrrigationService(ScheduledExecutorService executorService) {
        this.executorService = executorService;
    }

    public String irrigatePlot(Long plotId) {
        TimeSlot timeSlot = timeSlotRepo.findById(plotId).orElseThrow(() -> new NotFoundException("Time slot not found"));

        if (timeSlot.getStatus() == Status.PENDING) {
            // Schedule the irrigation process to start after a delay
            if(timeSlot.getStartTime()== LocalTime.now()) {
                executorService.schedule(() -> {
                    // Simulate the irrigation process
                    timeSlot.setStatus(Status.IRRIGATED);
                    timeSlotRepo.save(timeSlot);
                }, 5, TimeUnit.SECONDS); // Delay of 5 seconds (adjust as needed)
            }
        }
        return "Started";
    }


//    public TimeSlot updateSlotStatus(Long timeSlotId, TimeSlot updatedTimeSlot) {
//        TimeSlot timeSlot = timeSlotRepo.findById(timeSlotId).orElseThrow(() -> new NotFoundException("Time slot not found"));
//        timeSlot.setStatus(updatedTimeSlot.getStatus());
//        return timeSlotRepo.save(timeSlot);
//    }



}

