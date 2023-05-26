package com.example.irrigationSystem.PlotOfLand.Repository;

import com.example.irrigationSystem.PlotOfLand.Model.Plot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlotRepo extends JpaRepository<Plot,Long> {
}
