package com.cars.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cars.models.Car;
import com.cars.service.CarService;



@RestController
public class CarRestController {

	@Autowired
	CarService carService;
	
         @RequestMapping(value = "/carlist", method = RequestMethod.GET)
        public List<Car> getList() {
        return carService.getAllCars();
    }
	
        @RequestMapping(value = "/search", method = RequestMethod.GET)
        public List<Car> searchKey(@RequestParam(value = "key") String key,
        @RequestParam(value = "criteria", defaultValue = "all") String criteria) {
            
        return carService.Search(key, criteria);
    }      
}
