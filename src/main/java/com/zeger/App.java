package com.zeger;

import com.zeger.dto.AggregateType;
import com.zeger.service.TopCityService;

import java.util.List;

/**
 * @author Pavel Zeger
 */
public class App {

    public static void main(String[] args) {
        List<String> cities = List.of("1", "2", "3", "4");
        TopCityService topCityService = new TopCityService();

        AggregateType avg = AggregateType.AVG;
        List<String> topCitiesByAvg = topCityService.getTopCities(cities, avg);
        topCitiesByAvg.forEach(System.out::println);
        
        System.out.println("***");
        
        AggregateType max = AggregateType.MAX;
        List<String> topCitiesByMax = topCityService.getTopCities(cities, max);
        topCitiesByMax.forEach(System.out::println);
    }
}
