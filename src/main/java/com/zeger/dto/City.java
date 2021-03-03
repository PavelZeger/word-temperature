package com.zeger.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

/**
 * @author Pavel Zeger
 */
@Builder
@AllArgsConstructor
@Getter
public class City {

    private String id;
    private String name;
    private int population;

}
