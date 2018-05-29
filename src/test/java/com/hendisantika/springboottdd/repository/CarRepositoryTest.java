package com.hendisantika.springboottdd.repository;

import com.hendisantika.springboottdd.domain.Car;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-tdd
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 29/05/18
 * Time: 12.49
 * To change this template use File | Settings | File Templates.
 */

@RunWith(SpringRunner.class)
@DataJpaTest
public class CarRepositoryTest {
    @Autowired
    private CarRepository repository;

    @Autowired
    private TestEntityManager entityManager;

    @Test
    public void findByName() {

        // This will get the test entity manager to insert the object to the database
        // and get recreate it.
        // if were to use jpa save method, then you are just testing on the cache but not the actual persistence
//        Car savedCar = entityManager.persistFlushFind(new Car("prius","hybrid"));
        Car car = repository.findByName("Mobilio");

        Assertions.assertThat(car.getName()).isEqualTo("Mobilio");

    }

}