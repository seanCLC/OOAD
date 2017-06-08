package com.cumt.game.domain.monster;

import com.cumt.game.domain.equipment.Cloth;
import com.cumt.game.domain.equipment.Weapon;

/**
 * 怪物哥布林的抽象类
 * Created by 雷祥 on 2017/6/8.
 */

public abstract class Goblin {

    private int attack = 100;
    private int defend = 100;

    private Cloth cloth;
    private Weapon weapon;

}
