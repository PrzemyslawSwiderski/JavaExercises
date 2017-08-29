package com.pswiderski.common.cars;

public class Car {

  @Override
  public String toString() {
    return "Car{" +
        "name='" + name + '\'' +
        ", price=" + price +
        ", engine='" + engine + '\'' +
        '}';
  }

  private String name;

  private Double price;

  private String engine;

  public Car() {
    initFields();
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public String getEngine() {
    return engine;
  }

  public void setEngine(String engine) {
    this.engine = engine;
  }

  public void initFields() {
    setName("default");
    setEngine("default");
    setPrice(0.0);
  }

}