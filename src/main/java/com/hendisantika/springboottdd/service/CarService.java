package com.hendisantika.springboottdd.service;

import com.hendisantika.springboottdd.domain.Car;
import com.hendisantika.springboottdd.exception.CarNotFoundException;
import com.hendisantika.springboottdd.repository.CarRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-tdd
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 27/05/18
 * Time: 05.21
 * To change this template use File | Settings | File Templates.
 */
@Slf4j
@Service
public class CarService {


    private CarRepository carRepository;

    @Autowired
    public CarService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @Cacheable("cars")
    public Car getCarDetails(String carName) {
        Car car = carRepository.findByName(carName);
        if (car == null) {
            throw new CarNotFoundException();
        }
        return car;
    }
}