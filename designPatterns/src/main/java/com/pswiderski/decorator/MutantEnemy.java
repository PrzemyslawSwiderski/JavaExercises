package com.pswiderski.decorator;

import com.pswiderski.common.game.Enemy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MutantEnemy extends EnemyDecorator {

  private String[] newTraits = {"mutant", "moreDmg"};

  public MutantEnemy(Enemy enemy) {
    super(enemy);
  }

  public void attack() {
    this.enemy.attack();
    System.out.println(this.getClass().getSimpleName() + " is doing 10 dmg");

  }

  public List<String> traits() {
    List<String> allTraits = new ArrayList<>(this.enemy.traits());
    Collections.addAll(allTraits, newTraits);
    return allTraits;
  }

}
