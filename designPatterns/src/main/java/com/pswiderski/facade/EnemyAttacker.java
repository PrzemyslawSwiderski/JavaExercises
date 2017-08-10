package com.pswiderski.facade;

import com.pswiderski.common.game.BasicEnemy;
import com.pswiderski.common.game.Enemy;
import com.pswiderski.decorator.EnemyDecorator;
import com.pswiderski.decorator.MutantEnemy;
import com.pswiderski.decorator.SuperAggressiveEnemy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EnemyAttacker {


  public void attackWithMutantEnemy() {
    Enemy mutant = new MutantEnemy(new BasicEnemy());
    System.out.println("mutant attacking:");
    mutant.attack();
  }

  public Enemy getMutantEnemy() {
    return new MutantEnemy(new BasicEnemy());
  }


  public void attackWithSuperAggressiveMutantEnemy() {
    Enemy superAggressiveMutant = new SuperAggressiveEnemy(new MutantEnemy(new BasicEnemy()));
    System.out.println("superAggressiveMutant attacking:");
    superAggressiveMutant.attack();
  }

  public Enemy getSuperAggressiveMutantEnemy() {
    return new SuperAggressiveEnemy(new MutantEnemy(new BasicEnemy()));
  }

  public Enemy getHyperSuperAggressiveMutantEnemy() {
    Enemy hyperSuperAggressiveMutant = new EnemyDecorator(
        new SuperAggressiveEnemy(new MutantEnemy(new BasicEnemy()))) {

      public void attack() {
        this.enemy.attack();
        System.out.println("HyperSuperAggressiveMutant is doing 30 dmg");

      }

      public List<String> traits() {
        List<String> allTraits = new ArrayList<>(this.enemy.traits());
        Collections.addAll(allTraits, "hyper", "massiveDMG");
        return allTraits;

      }
    };
    return hyperSuperAggressiveMutant;
  }

}
