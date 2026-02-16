package com.project_6.temp.Cpu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {
    @Autowired
    private JavaMailSender mailSender;

    public void sendHighTemperatureEmail(double temperature) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("nestamin42@gmail.com");
        message.setSubject("URGENT: High CPU Temperature Detected!");
        message.setText("Warning! Your CPU temperature is currently" + temperature + "°C, which exceeds the safety threshold.");

        try{
            mailSender.send(message);
            System.out.println("Email sent successfully");
        }catch (Exception e){
            System.out.println("An error occurred while sending email" + e.getMessage());
        }
    }
}
