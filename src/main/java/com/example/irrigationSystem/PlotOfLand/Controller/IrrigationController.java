package com.example.irrigationSystem.PlotOfLand.Controller;

import com.example.irrigationSystem.PlotOfLand.Model.TimeSlot;
import com.example.irrigationSystem.PlotOfLand.NotFoundException;
import com.example.irrigationSystem.PlotOfLand.Repository.TimeSlotRepo;
import com.example.irrigationSystem.PlotOfLand.Service.IrrigationService;
import com.example.irrigationSystem.PlotOfLand.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/plots/{plotId}/time-slots/{timeSlotId}")
public class IrrigationController {
    @Autowired
    TimeSlotRepo timeSlotRepo;
    @Autowired
    IrrigationService irrigationService;
    @PostMapping("irrigation")
    public void irrigationPlot(@PathVariable long plotId){
        irrigationService.irrigatePlot(plotId);

        }
    }
