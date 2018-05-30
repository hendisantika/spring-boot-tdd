package com.hendisantika.springboottdd;

import com.hendisantika.springboottdd.domain.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
public class SpringBootTddApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void getCar_returnsCarDetails() {
        // arrange

        // act
        ResponseEntity<Car> response = restTemplate
                .getForEntity("/cars/prius", Car.class);

        // assert
        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(response.getBody().getName()).isEqualTo("prius");
        assertThat(response.getBody().getType()).isEqualTo("hybrid");

    }

}
