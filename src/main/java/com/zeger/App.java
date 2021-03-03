package com.zeger;

import com.zeger.service.TopCityService;

import java.util.List;

/**
 * @author Pavel Zeger
 */
public class App {

    public static void main(String[] args) {
        List<String> cities = List.of("1", "2", "3", "4", "5");
        String aggregationType = "avg";
        TopCityService topCityService = new TopCityService();
        List<String> topCities = topCityService.getTopCities(cities, aggregationType);
        topCities.forEach(System.out::println);
    }
}
