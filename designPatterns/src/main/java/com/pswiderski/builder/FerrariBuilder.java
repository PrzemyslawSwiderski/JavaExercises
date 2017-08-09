package com.pswiderski.builder;

public class FerrariBuilder extends CarsBuilder {

  @Override
  public void buildName() {
    getCar().setName("Ferrari");
  }

  @Override
  public void buildEngine() {
    getCar().setEngine("12V");
  }

  @Override
  public void buildPrice() {
    getCar().setPrice(112212321.0);
  }
}
