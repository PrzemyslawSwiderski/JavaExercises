package com.pswiderski.factory;

import com.pswiderski.common.cars.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CarFactoryTest {

    @Test
    public void factoryTest() {
        CarFactory carFactory = new CarFactory();

        Car audi = carFactory.getCar("AUDI");

        log.info(audi.toString());

        assertEquals(audi.getName(), "Audi");

        Car fiat = carFactory.getCar("FIAT");

        log.info(fiat.toString());

        assertEquals(fiat.getName(), "Fiat");
        Car toyota = carFactory.getCar("TOYOTA");

        log.info(toyota.toString());
        assertEquals(toyota.getName(), "Toyota");

        Car toyota2 = carFactory.getCar("toyota");

        log.info(toyota2.toString());

    }

}