package com.pswiderski.facade;

import com.pswiderski.common.game.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class EnemyAttackerTest {

    @Test
    public void attackWithMutantEnemy() {
        EnemyAttacker enemyAttacker = new EnemyAttacker();
        enemyAttacker.attackWithMutantEnemy();
        assertTrue(enemyAttacker.getMutantEnemy().traits().size() == 4);
    }

    @Test
    public void attackWithSuperAggressiveMutantEnemy() {
        EnemyAttacker enemyAttacker = new EnemyAttacker();
        enemyAttacker.attackWithSuperAggressiveMutantEnemy();
        assertTrue(enemyAttacker.getSuperAggressiveMutantEnemy().traits().size() == 6);
    }

    @Test
    public void attackWithHyperSuperAggressiveMutantEnemy() {
        EnemyAttacker enemyAttacker = new EnemyAttacker();
        Enemy hyperSuperAggressiveMutantEnemy = enemyAttacker.getHyperSuperAggressiveMutantEnemy();
        hyperSuperAggressiveMutantEnemy.attack();
        assertTrue(hyperSuperAggressiveMutantEnemy.traits().size() == 8);
    }

}