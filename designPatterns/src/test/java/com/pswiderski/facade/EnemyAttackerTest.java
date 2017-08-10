package com.pswiderski.facade;

import com.pswiderski.common.game.Enemy;
import org.junit.Assert;
import org.junit.Test;

public class EnemyAttackerTest {

  @Test
  public void attackWithMutantEnemy() {
    EnemyAttacker enemyAttacker = new EnemyAttacker();
    enemyAttacker.attackWithMutantEnemy();
    Assert.assertTrue(enemyAttacker.getMutantEnemy().traits().size() == 4);
  }

  @Test
  public void attackWithSuperAggressiveMutantEnemy() {
    EnemyAttacker enemyAttacker = new EnemyAttacker();
    enemyAttacker.attackWithSuperAggressiveMutantEnemy();
    Assert.assertTrue(enemyAttacker.getSuperAggressiveMutantEnemy().traits().size() == 6);
  }

  @Test
  public void attackWithHyperSuperAggressiveMutantEnemy() {
    EnemyAttacker enemyAttacker = new EnemyAttacker();
    Enemy hyperSuperAggressiveMutantEnemy = enemyAttacker.getHyperSuperAggressiveMutantEnemy();
    hyperSuperAggressiveMutantEnemy.attack();
    Assert.assertTrue(hyperSuperAggressiveMutantEnemy.traits().size() == 8);
  }

}