package com.pswiderski.factory;

import com.pswiderski.common.Audi;
import com.pswiderski.common.Car;
import com.pswiderski.common.Fiat;
import com.pswiderski.common.Toyota;

public class CarFactory {

  public Car getCar(String carType) {
    if (carType == null) {
      return new Car();
    }

    switch (carType.toUpperCase()) {
      case "AUDI":
        return new Audi();
      case "FIAT":
        return new Fiat();
      case "TOYOTA":
        return new Toyota();
    }

    return new Car();
  }

}
