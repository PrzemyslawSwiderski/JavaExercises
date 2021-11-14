package com.pswiderski.bridge;

import lombok.Data;

@Data
public abstract class Weapon {

    private String name;

    private int damage;

    public Weapon(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }
}
