package com.pswiderski.decorator;

import com.pswiderski.common.game.Enemy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperAggressiveEnemy extends EnemyDecorator {


    public SuperAggressiveEnemy(Enemy enemy) {
        super(enemy);
    }

    public void attack() {
        this.enemy.attack();
        System.out.println(this.getClass().getSimpleName() + " is doing 20 dmg");

    }

    public List<String> traits() {
        List<String> allTraits = new ArrayList<>(this.enemy.traits());
        Collections.addAll(allTraits, "super", "aggressive");
        return allTraits;
    }

}
