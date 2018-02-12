package com.aslan.mongoaggregation.dto;

import com.aslan.mongoaggregation.enums.Profile;
import lombok.Data;

import java.time.Month;

/**
 * Created by aslan.atasoy on 02/08/2018.
 */
@Data
public class AverageResultDTO {
    private String _id;
    private Long avgConsumption;
}
