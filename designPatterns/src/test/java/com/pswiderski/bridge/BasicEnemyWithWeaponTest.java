package com.pswiderski.bridge;

import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;

@Slf4j
public class BasicEnemyWithWeaponTest {

  @Test
  public void attackWithWeaponSword() {

    EnemyWithWeapon enemyWithSword = new BasicEnemyWithWeapon(new Sword());

    log.info(enemyWithSword.toString());

    enemyWithSword.attackWithWeapon();

    Assert.assertTrue(enemyWithSword.getWeapon() instanceof Sword);

  }

  @Test
  public void attackWithWeaponBow() {

    EnemyWithWeapon enemyWithBow = new BasicEnemyWithWeapon(new Bow());

    log.info(enemyWithBow.toString());

    enemyWithBow.attackWithWeapon();

    Assert.assertTrue(enemyWithBow.getWeapon() instanceof Bow);

  }

  @Test
  public void attackWithWeaponSpear() {

    EnemyWithWeapon enemyWithSpear = new BasicEnemyWithWeapon(new Spear());

    log.info(enemyWithSpear.toString());

    enemyWithSpear.attackWithWeapon();

    Assert.assertTrue(enemyWithSpear.getWeapon() instanceof Spear);

  }
}