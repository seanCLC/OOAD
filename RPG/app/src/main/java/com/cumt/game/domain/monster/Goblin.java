package com.cumt.game.domain.monster;

import com.cumt.game.domain.equipment.Cloth;
import com.cumt.game.domain.equipment.Weapon;

/**
 * 怪物哥布林的类
 * Created by 雷祥 on 2017/6/8.
 */

public class Goblin {

    public final int blood = 100;

    public final int attack = 100;
    public final int defend = 100;

    public Cloth cloth;
    public Weapon weapon;


    public int getAttack(){
        return attack + weapon.getAttack();
    }

    public int getDefend(){
        return defend + cloth.getDefend();
    }

    public int getBlood(){
        return blood;
    }

}
