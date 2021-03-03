package com.zeger.aggregator;

import com.zeger.dto.City;
import com.zeger.dto.DailyTemp;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Pavel Zeger
 */
@RequiredArgsConstructor
public class AverageAggregator extends Aggregator {

    private final List<String> ids;

    @Override
    public List<String> aggregate() {
        Set<City> cities = getCities(ids);
        Map<String, List<DailyTemp>> cityByTemp = getCityByTemp(cities);
        Map<String, Double> cityByAvgTemp = cityByTemp.entrySet().parallelStream()
                .collect(Collectors.toUnmodifiableMap(Map.Entry::getKey, entry -> getAverage(entry.getValue())));
        return cityByAvgTemp.entrySet()
                .parallelStream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(3)
                .map(Map.Entry::getKey)
                .collect(Collectors.toUnmodifiableList());
    }

    private double getAverage(List<DailyTemp> dailyTemps) {
        return dailyTemps.parallelStream()
                .mapToDouble(DailyTemp::getTemperature)
                .summaryStatistics()
                .getAverage();
    }
}
