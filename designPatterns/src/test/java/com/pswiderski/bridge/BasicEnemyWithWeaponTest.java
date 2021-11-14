package com.pswiderski.bridge;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

@Slf4j
public class BasicEnemyWithWeaponTest {

    @Test
    public void attackWithWeaponSword() {

        EnemyWithWeapon enemyWithSword = new BasicEnemyWithWeapon(new Sword());

        log.info(enemyWithSword.toString());

        enemyWithSword.attackWithWeapon();

        assertTrue(enemyWithSword.getWeapon() instanceof Sword);

    }

    @Test
    public void attackWithWeaponBow() {

        EnemyWithWeapon enemyWithBow = new BasicEnemyWithWeapon(new Bow());

        log.info(enemyWithBow.toString());

        enemyWithBow.attackWithWeapon();

        assertTrue(enemyWithBow.getWeapon() instanceof Bow);

    }

    @Test
    public void attackWithWeaponSpear() {

        EnemyWithWeapon enemyWithSpear = new BasicEnemyWithWeapon(new Spear());

        log.info(enemyWithSpear.toString());

        enemyWithSpear.attackWithWeapon();

        assertTrue(enemyWithSpear.getWeapon() instanceof Spear);

    }
}