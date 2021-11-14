package com.pswiderski.builder;

import com.pswiderski.common.cars.Car;

public class BuildManager {

    private CarsBuilder carsBuilder;


    public void setCarsBuilder(CarsBuilder carsBuilder) {
        this.carsBuilder = carsBuilder;
    }

    public Car buildCar() {
        carsBuilder.buildName();
        carsBuilder.buildEngine();
        carsBuilder.buildPrice();
        return carsBuilder.getCar();
    }
}
