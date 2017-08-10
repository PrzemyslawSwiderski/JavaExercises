package com.pswiderski.singleton;


import static org.junit.Assert.assertEquals;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

@Slf4j
public class SingletonTest {

  @Test
  public void testEnumSingleton() {
    String helloText = SingletonEnum.INSTANCE.getHelloText();
    log.info(helloText);
    assertEquals(helloText, "Hi, Singleton by enum here!!!");
  }

  @Test
  public void testClassSingleton() {
    String helloText = SingletonClass.getInstance().getHelloText();
    log.info(helloText);
    assertEquals(helloText, "Hi, Singleton by class here!!!");
  }
}
