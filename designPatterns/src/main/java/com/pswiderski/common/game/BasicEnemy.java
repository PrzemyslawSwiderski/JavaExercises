package com.pswiderski.common.game;

import java.util.Arrays;
import java.util.List;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicEnemy implements Enemy {


  private List<String> traits = Arrays.asList("basicDmg", "basicHealth");

  @Override
  public void attack() {
    log.info(this.getClass().getSimpleName() + " is doing 5 dmg");
  }

  @Override
  public List<String> traits() {
    return traits;
  }

  @Override
  public String toString() {
    return "BasicEnemy{" +
        "traits=" + traits +
        '}';
  }

}
