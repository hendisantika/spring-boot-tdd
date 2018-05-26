package com.hendisantika.springboottdd.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-tdd
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 26/05/18
 * Time: 19.09
 * To change this template use File | Settings | File Templates.
 */
@Data
@Entity
@NoArgsConstructor
@ToString
public class Car {

    @Id
    @GeneratedValue
    private Long id;

    private String name;

    private String type;

    public Car(String name, String type) {
        this.name = name;
        this.type = type;
    }
}