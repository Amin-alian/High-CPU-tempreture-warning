package com.project_6.temp.Cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TempMonitorScheduler {
    @Autowired
    private HardwareService hardwareService;

    @Autowired
    private EmailService emailService;

    @Value("${cpu.temp.threshold}")
    private double threshold;


    @Scheduled(fixedRate = 60000)
    public void checkTemperature() {
        double currentTemp  = hardwareService.getCpuTemperature();
        System.out.println("Current temperature: " + currentTemp);
        if (currentTemp > threshold && currentTemp > 0) {
            System.out.println("Threshold exceeded! Sending email...");
            emailService.sendHighTemperatureEmail(currentTemp);
        }
    }
}
