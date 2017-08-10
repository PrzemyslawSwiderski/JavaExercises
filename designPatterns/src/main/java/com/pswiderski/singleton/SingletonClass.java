package com.pswiderski.singleton;


public class SingletonClass {

  private static SingletonClass instance = new SingletonClass();

  private final String helloText = "Hi, Singleton by class here!!!";

  private SingletonClass(){}

  public static SingletonClass getInstance(){
    return instance;
  }

  public String getHelloText(){
    return helloText;
  }

}