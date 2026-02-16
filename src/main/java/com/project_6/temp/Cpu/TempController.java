package com.project_6.temp.Cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TempController {

    @Autowired
    private HardwareService hardwareService;

    @GetMapping("api/temp")
    public String getTemp() {
        double temp = hardwareService.getCpuTemperature();
        return "Current temperature: " + temp + "°C";
    }
}
