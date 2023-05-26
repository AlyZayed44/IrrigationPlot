package com.example.irrigationSystem.PlotOfLand.Controller;

import com.example.irrigationSystem.PlotOfLand.Model.Plot;
import com.example.irrigationSystem.PlotOfLand.Model.TimeSlot;
import com.example.irrigationSystem.PlotOfLand.Repository.PlotRepo;
import com.example.irrigationSystem.PlotOfLand.Service.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plot")
public class PlotController {
    @Autowired
    PlotService plotService;
    @Autowired
    private PlotRepo plotRepo;

    @PostMapping
    public Plot addPlot(@RequestBody Plot plot){
        return plotService.AddPlot(plot);
    }

    @PostMapping("/{plotId}/timeSlot")
    public TimeSlot ConfigureTimeSlot(@PathVariable Long plotId, @RequestBody TimeSlot timeSlot){
        return plotService.configureTimeSlot(plotId,timeSlot);
    }
    @GetMapping
    public List<Plot> getAllPlots(){
        return plotService.getAllPlots();
    }
    @GetMapping("/{id}")
    public Plot getPlotById(@PathVariable long id){
        return plotService.GetPlotById(id);
    }
    @PutMapping("/{id}/edit")
    public Plot UpdatePlot(@PathVariable long id,@RequestBody Plot plot){
        return plotService.updatePlot(id,plot);
    }
    @DeleteMapping("/{id}")
    public List<Plot> DeletePlot(@PathVariable long id){
        return plotService.DeletePlot(id);
    }
}
