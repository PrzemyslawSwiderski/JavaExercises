package com.pswiderski.builder;

import com.pswiderski.common.Car;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

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

    Assert.assertEquals(mazda.getName(),"Mazda");
    buildManager.setCarsBuilder(ferrariBuilder);

    Car ferrari = buildManager.buildCar();

    System.out.println(ferrari);
    Assert.assertEquals(ferrari.getName(),"Ferrari");

  }

}