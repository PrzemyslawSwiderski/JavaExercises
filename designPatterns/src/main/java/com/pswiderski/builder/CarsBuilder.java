package com.pswiderski.builder;

import com.pswiderski.common.cars.Car;

public abstract class CarsBuilder {

    private Car car = new Car();

    public Car getCar() {
        return car;
    }

    public abstract void buildName();

    public abstract void buildEngine();

    public abstract void buildPrice();

}
