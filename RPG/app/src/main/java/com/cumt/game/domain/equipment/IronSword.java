package com.cumt.game.domain.equipment;

/**
 * 铁剑，继承自武器
 * Created by 雷祥 on 2017/6/12.
 */

public class IronSword extends Weapon {
    private final int attack = 50;

    @Override
    public int getAttack() {
        return super.getAttack() + attack;
    }
}
