package com.pswiderski.bridge;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BasicEnemyWithWeapon extends EnemyWithWeapon {

  public BasicEnemyWithWeapon(Weapon weapon) {
    this.setWeapon(weapon);
  }

  @Override
  public void attackWithWeapon() {
    log.info(this + " is attacking with: " + getWeapon());
  }

  @Override
  public String toString() {
    return "BasicEnemyWithWeapon{" +
        "weapon=" + getWeapon() +
        '}';
  }
}
