package com.aslan.mongoaggregation.exception.consumption;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by aslan.atasoy on 01/29/2018.
 */
@Getter
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConsumptionAlreadyExistException extends RuntimeException{
    public ConsumptionAlreadyExistException(String message) {
        super(message);
    }
}
