package com.medLAB.controllers;

import com.medLAB.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DashboardController {

    public final DashboardService dashboardService;

    @GetMapping("/dashboard")
    public void mostraEstatisticas(){
        dashboardService.mostrarEstatistiscas();
    }
}
