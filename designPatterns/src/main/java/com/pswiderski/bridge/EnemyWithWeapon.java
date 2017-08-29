package com.pswiderski.bridge;

import com.pswiderski.common.game.BasicEnemy;
import lombok.Getter;

public abstract class EnemyWithWeapon extends BasicEnemy {

  @lombok.Setter
  @Getter
  private Weapon weapon;

  public abstract void attackWithWeapon();

}
