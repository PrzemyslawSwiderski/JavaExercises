package com.pswiderski.factory;

import com.pswiderski.common.cars.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class CarFactoryTest {

  @Test
  public void factoryTest() {
    CarFactory carFactory = new CarFactory();

    Car audi = carFactory.getCar("AUDI");

    log.info(audi.toString());

    Assert.assertEquals(audi.getName(),"Audi");

    Car fiat = carFactory.getCar("FIAT");

    log.info(fiat.toString());

    Assert.assertEquals(fiat.getName(),"Fiat");
    Car toyota = carFactory.getCar("TOYOTA");

    log.info(toyota.toString());
    Assert.assertEquals(toyota.getName(),"Toyota");

    Car toyota2 = carFactory.getCar("toyota");

    log.info(toyota2.toString());

  }

}