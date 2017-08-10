package com.pswiderski.factory;

import com.pswiderski.common.cars.Audi;
import com.pswiderski.common.cars.Car;
import com.pswiderski.common.cars.Fiat;
import com.pswiderski.common.cars.Toyota;

public class CarFactory {

  public Car getCar(String carType) {
    if (carType == null) {
      throw new IllegalArgumentException("Car type should not be null! ");
    }

    switch (carType.toUpperCase()) {
      case "AUDI":
        return new Audi();
      case "FIAT":
        return new Fiat();
      case "TOYOTA":
        return new Toyota();
      default:
        throw new IllegalArgumentException("Cannot create car of type " + carType);
    }

  }

}
