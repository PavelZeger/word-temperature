package com.zeger.dto;


import com.zeger.aggregator.AverageAggregator;
import com.zeger.aggregator.MaxAggregator;

import java.util.List;

/**
 * @author Pavel Zeger
 */
public enum AggregateType {

    AVG {
        @Override
        public List<String> execute(List<String> ids) {
            AverageAggregator averageAggregator = new AverageAggregator(ids);
            return averageAggregator.aggregate();
        }
    },
    MAX {
        @Override
        public List<String> execute(List<String> ids) {
            MaxAggregator maxAggregator = new MaxAggregator(ids);
            return maxAggregator.aggregate();
        }
    };

    public abstract List<String> execute(List<String> ids);

}
