package com.zeger.aggregator;

import com.zeger.dto.City;
import com.zeger.dto.DailyTemp;
import com.zeger.service.CityService;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 */
public abstract class Aggregator {

    int populationThreshold = 50000;
    CityService cityService = new CityService();

    public Set<City> getCities(List<String> ids) {
        return cityService.getAllCitiesByIds(ids.stream().collect(Collectors.toUnmodifiableSet()));
    }

    public List<String> getTopCities(Map<String, Double> cityByTemp) {
        return cityByTemp.entrySet()
                .parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
    }

    public Map<String, List<DailyTemp>> getCityByTemp(Set<City> cities) {
        return cities
                .parallelStream()
                .filter(city -> city.getPopulation() >= populationThreshold)
                .map(City::getId)
                .collect(Collectors.toUnmodifiableMap(id -> id, cityService::getLastYearTemperature));
    }

    public abstract List<String> aggregate();

}
