package com.pswiderski.builder;

import com.pswiderski.common.cars.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@Slf4j
public class CarsBuilderTest {

    @Test
    public void testBuilder() {
        BuildManager buildManager = new BuildManager();

        CarsBuilder mazdaBuilder = new MazdaBuilder();

        CarsBuilder ferrariBuilder = new FerrariBuilder();

        buildManager.setCarsBuilder(mazdaBuilder);

        Car mazda = buildManager.buildCar();

        log.info(mazda.toString());

        assertEquals(mazda.getName(), "Mazda");
        buildManager.setCarsBuilder(ferrariBuilder);

        Car ferrari = buildManager.buildCar();

        System.out.println(ferrari);
        assertEquals(ferrari.getName(), "Ferrari");

    }

}