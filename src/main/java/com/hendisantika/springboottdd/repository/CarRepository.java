package com.hendisantika.springboottdd.repository;

import com.hendisantika.springboottdd.domain.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

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
@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
    Car findByName(String carName);
}
