package com.aslan.mongoaggregation.exception.consumption;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by aslan.atasoy on 01/28/2018.
 */
@Getter
@ResponseStatus(value=HttpStatus.NOT_FOUND)
public class ConsumptionNotFoundException extends RuntimeException {

    public ConsumptionNotFoundException(String message) {
        super(message);
    }
}
