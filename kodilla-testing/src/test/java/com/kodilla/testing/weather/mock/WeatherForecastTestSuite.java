package com.kodilla.testing.weather.mock;

import com.kodilla.testing.weather.stub.Temperatures;
import com.kodilla.testing.weather.stub.WeatherForecast;

import java.util.Map;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class WeatherForecastTestSuite {

    private static Map<String, Double> temperaturesMap;

    @BeforeAll
    static void setup() {
        temperaturesMap = Map.of(
                "Rzeszów", 25.5,
                "Kraków", 26.2,
                "Wroclaw", 24.8,
                "Warszawa", 25.2,
                "Gdansk", 26.1);
    }

    @Mock
    Temperatures temperaturesMock;

    @DisplayName("The method should return the number of sensors")
    @Test
    public void testCalculateForecastWithMock() {
        //given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //when
        int quantityOfSensors = weatherForecast.calculateForecast().size();
        //then
        assertEquals(5, quantityOfSensors);
    }

    @DisplayName("The method should return the average value of all sensors")
    @Test
    public void testGetAverageTemperature() {
        //given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //when
        double result = weatherForecast.getAverageTemperature();

        //then
        assertEquals(25.56, result);
    }

    @DisplayName("The method should return the median value of all sensors")
    @Test
    public void testGetMedianTemperature() {
        //given
        when(temperaturesMock.getTemperatures()).thenReturn(temperaturesMap);
        WeatherForecast weatherForecast = new WeatherForecast(temperaturesMock);

        //when
        double result = weatherForecast.getMedianTemperature();

        //then
        assertEquals(25.5, result);
    }
}