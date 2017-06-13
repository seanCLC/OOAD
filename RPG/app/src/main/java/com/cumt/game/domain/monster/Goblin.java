package com.cumt.game.domain.monster;

import com.cumt.game.domain.entity.Person;
import com.cumt.game.domain.equipment.Cloth;
import com.cumt.game.domain.equipment.Weapon;

import java.math.BigDecimal;

/**
 * 怪物哥布林的类
 * Created by 雷祥 on 2017/6/8.
 */

public class Goblin {

    private int blood = 100;

    private final int attack = 10;
    private final int defend = 10;

    public Cloth cloth;
    public Weapon weapon;


    public int getAttack(){
        int real = 0;

        if(weapon != null){
            real = attack + weapon.getAttack();
        }else{
            real = attack;
        }
        return real;

    }


    public int getDefend(){
        int real = 0;
        if(cloth != null){
            real = defend + cloth.getDefend();
        }else {
            real = defend;
        }
        return real;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public int getBlood(){
        return blood;
    }

    public boolean attackToDeath(Person person){
        float percent = new BigDecimal(person.getDefend()).divide(new BigDecimal(100)).floatValue();
        person.setBlood(person.getBlood() - ( int )(getAttack() * percent));
        return (person.getBlood() > 0 ? false : true);
    }

}
