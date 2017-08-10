package com.pswiderski.singleton;

public enum SingletonEnum {

  INSTANCE;

  private final String helloText = "Hi, Singleton by enum here!!!";

  public String getHelloText(){
    return helloText;
  }

}
