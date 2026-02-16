package com.project_6.temp.Cpu;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import tools.jackson.databind.JsonNode;
import tools.jackson.databind.ObjectMapper;

@Service
public class HardwareService {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String LHM_URL = "http://localhost:8085/data.json";

    public double getCpuTemperature() {
        try{
            String jsonResponse = restTemplate.getForObject(LHM_URL, String.class);
            ObjectMapper mapper = new ObjectMapper();
            JsonNode root = mapper.readTree(jsonResponse);

            return findCpuTempRecursively(root);
        } catch (Exception e){
            System.err.println("Error connecting to LibreHardwareMonitor: " + e.getMessage());
        }
        return 0.0;
    }

    private double findCpuTempRecursively(JsonNode root) {
        if (root == null) return 0.0;
        if(root.has("Text") && root.has("Value") && root.has("Type")){
            String text = root.get("Text").asText();
            String value = root.get("Value").asText();
            String type = root.get("Type").asText();

            if (type.equals("Temperature") && text.contains("Core Max")) {
                return parseTemperature(value);
            }
        }
        if (root.has("Children")){
            for (JsonNode child : root.get("Children")){
                double temperature = findCpuTempRecursively(child);
                if (temperature > 0.0) {
                    return temperature;
                }
            }
        }
        return 0.0;
    }

    private double parseTemperature(String value) {
        try {
            String number = value.replaceAll("[^0-9.]", "");
            if (number.isEmpty()) return 0.0;

            return Double.parseDouble(number);
        } catch (NumberFormatException e) {
            System.err.println("Could not parse temperature string: " + value);
            return 0.0;
        }
    }
}
