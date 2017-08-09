package com.pswiderski.builder;

public class MazdaBuilder extends CarsBuilder {

  @Override
  public void buildName() {
    getCar().setName("Mazda");
  }

  @Override
  public void buildEngine() {
    getCar().setEngine("3.0TDI");
  }

  @Override
  public void buildPrice() {
    getCar().setPrice(11221.0);
  }

}
