package com.pswiderski.decorator;

import com.pswiderski.common.game.Enemy;

import java.util.List;

public abstract class EnemyDecorator implements Enemy {

    protected Enemy enemy;


    public EnemyDecorator(Enemy enemy) {
        this.enemy = enemy;
    }


    @Override
    public void attack() {
        this.enemy.attack();
    }

    @Override
    public List<String> traits() {
        return this.enemy.traits();
    }
}
