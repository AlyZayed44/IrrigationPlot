package com.example.irrigationSystem.PlotOfLand.Service;

import com.example.irrigationSystem.PlotOfLand.Model.Plot;
import com.example.irrigationSystem.PlotOfLand.Model.TimeSlot;
import com.example.irrigationSystem.PlotOfLand.NotFoundException;
import com.example.irrigationSystem.PlotOfLand.Repository.PlotRepo;
import com.example.irrigationSystem.PlotOfLand.Repository.TimeSlotRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlotService {
    @Autowired
    PlotRepo plotRepo;
    @Autowired
    TimeSlotRepo timeSlotRepo;
    public Plot AddPlot(Plot plot){
        return plotRepo.saveAndFlush(plot);
    }
    public Plot updatePlot(long id,Plot plot){
        Plot plot1 =plotRepo.findById(id)
                .orElseThrow(() -> new NotFoundException("Plot not found"));
        plot1.setName(plot.getName());
        plot1.setArea(plot.getArea());
        plot1.setLocation(plot.getLocation());
        return plotRepo.saveAndFlush(plot1);

    }
    public TimeSlot configureTimeSlot(Long plotId, TimeSlot timeSlot) {
        Plot plot = plotRepo.findById(plotId).orElseThrow(() -> new NotFoundException("Plot not found"));
        timeSlot.setPlot(plot);
        return timeSlotRepo.save(timeSlot);
    }
    public List<Plot> getAllPlots() {
        return plotRepo.findAll();
    }
    public Plot GetPlotById(Long plotId) {
        Plot plot = plotRepo.findById(plotId).orElseThrow(() -> new NotFoundException("Plot not found"));
        return plot;
}
public List<Plot>DeletePlot(long id){
        plotRepo.deleteById(id);
        return getAllPlots();
}
}
