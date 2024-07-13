package com.kodilla.testing.weather.stub;

import java.util.*;

public class WeatherForecast {

    private Temperatures temperatures;

    public WeatherForecast(Temperatures temperatures) {
        this.temperatures = temperatures;
    }

    public Map<String, Double> calculateForecast() {
        Map<String, Double> resultMap = new HashMap<>();

        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            resultMap.put(temperature.getKey(), temperature.getValue() + 1);
        }
        return resultMap;
    }

    public double getAverageTemperature() {
        double result = 0.0;
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            result += temperature.getValue();
        }
        return result / temperatures.getTemperatures().size();
    }

    public double getMedianTemperature() {
        List<Double> tempList = new ArrayList<>();
        for (Map.Entry<String, Double> temperature : temperatures.getTemperatures().entrySet()) {
            tempList.add(temperature.getValue());
        }
        if (tempList.size() % 2 == 0) {
            double a = tempList.get(tempList.size() / 2);
            double b = tempList.get(tempList.size() / 2 + 1);
            double result = (a + b) / 2;
            return result;
        } else {
            Collections.sort(tempList);
            return tempList.get(tempList.size() / 2);
        }
    }
}