package com.medLAB.controllers;

import com.medLAB.services.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class DashboardController {

    public final DashboardService dashboardService;

    @GetMapping("/dashboard")
    @ResponseStatus(HttpStatus.OK)
    public void mostraEstatisticas(){
        dashboardService.mostrarEstatistiscas();
    }
}
