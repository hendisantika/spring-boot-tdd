package com.hendisantika.springboottdd.controller;

import com.hendisantika.springboottdd.domain.Car;
import com.hendisantika.springboottdd.exception.CarNotFoundException;
import com.hendisantika.springboottdd.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-tdd
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 28/05/18
 * Time: 21.09
 * To change this template use File | Settings | File Templates.
 */
@RestController
public class CarController {

    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/cars")
    private Car getCars(@PathVariable("name") String carName) {
        return carService.getCarDetails(carName);
    }

    @GetMapping("/cars/{name}")
    private Car getCarsByName(@PathVariable("name") String carName) {
        return carService.getCarDetails(carName);
    }

    @ExceptionHandler
    @ResponseStatus(HttpStatus.NOT_FOUND)
    private void carNotFoundHandler(CarNotFoundException ex) {
    }

}
