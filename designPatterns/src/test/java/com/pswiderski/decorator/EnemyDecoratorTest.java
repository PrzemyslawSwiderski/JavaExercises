package com.pswiderski.decorator;

import com.pswiderski.common.game.BasicEnemy;
import com.pswiderski.common.game.Enemy;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class EnemyDecoratorTest {

    @Test
    public void decoratorTest() {
        Enemy mutant = new MutantEnemy(new BasicEnemy());

        assertArrayEquals(mutant.traits().toArray(),
                new String[]{"basicDmg", "basicHealth", "mutant", "moreDmg"});
        System.out.println("MUTANT:");
        mutant.attack();

        Enemy superAggressiveMutant = new SuperAggressiveEnemy(new MutantEnemy(new BasicEnemy()));

        assertArrayEquals(superAggressiveMutant.traits().toArray(),
                new String[]{"basicDmg", "basicHealth", "mutant", "moreDmg", "super", "aggressive"});
        System.out.println("SUPER AGGRESSIVE MUTANT:");
        superAggressiveMutant.attack();
    }

}