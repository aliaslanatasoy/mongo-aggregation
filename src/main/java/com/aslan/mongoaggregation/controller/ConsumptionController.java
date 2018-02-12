package com.aslan.mongoaggregation.controller;

import com.aslan.mongoaggregation.dto.ConsumptionDTO;
import com.aslan.mongoaggregation.service.ConsumptionService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by aslan.atasoy on 01/28/2018.
 */
@Controller
@RequestMapping("/consumption")
public class ConsumptionController {
    @Autowired
    ConsumptionService consumptionService;


    @ApiOperation(value = "Retrieve all consumptions", response = ConsumptionDTO.class)
    @GetMapping
    @ResponseBody
    public ResponseEntity getAllConsumptions(){
        return new ResponseEntity(consumptionService.finAllConsumptions(),HttpStatus.OK);
    }


    @ApiOperation(value = "Retrieve consumption", response = ConsumptionDTO.class)
    @GetMapping("/{id}")
    @ResponseBody
    public ResponseEntity getConsumption(@PathVariable String id){
        return new ResponseEntity(consumptionService.findConsumption(id), HttpStatus.OK);
    }

    @ApiOperation(value = "Add consumption", response = ConsumptionDTO.class)
    @PostMapping
    @ResponseBody
    public ResponseEntity addConsumption(@RequestBody ConsumptionDTO consumptionDTO){
        return new ResponseEntity(consumptionService.addConsumption(consumptionDTO),HttpStatus.CREATED);
    }

    @ApiOperation(value = "Delete consumption",response = String.class)
    @DeleteMapping
    public ResponseEntity deleteConsumption(@RequestParam("id") String id)throws Exception{
        consumptionService.deleteConsumption(id);
        return ResponseEntity.ok("Consumption with id: " + id + "deleted succesfully");
    }

    @ApiOperation(value = "Average of consumption by given month",response = String.class)
    @GetMapping(value = "/avg")
    public ResponseEntity findAverage(@RequestParam("month") String month){
        return ResponseEntity.ok(consumptionService.averageFractionByMonth(month));
    }

}
