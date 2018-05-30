package com.hendisantika.springboottdd;

import com.hendisantika.springboottdd.domain.Car;
import com.hendisantika.springboottdd.repository.CarRepository;
import com.hendisantika.springboottdd.service.CarService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-tdd
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 31/05/18
 * Time: 04.30
 * To change this template use File | Settings | File Templates.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
@AutoConfigureTestDatabase
@AutoConfigureCache
public class CachingTest {

    // Will require the spring application content for testing on the cache.
    // Therefore, will need to include the spring boot test.
    // But, since we do not require to test on the server, we will change the web environment to none.

    // Can also specify the cache config class

    @Autowired
    private CarService service;

    @MockBean
    private CarRepository carRepository;

    @Test
    public void caching() {

        given(carRepository.findByName(anyString())).willReturn(new Car("prius", "hybrid"));

        service.getCarDetails("prius");
        service.getCarDetails("prius");

        verify(carRepository, times(1)).findByName("prius");
    }

}