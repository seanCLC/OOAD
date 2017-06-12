package com.cumt.game.domain.monster;

import com.cumt.game.domain.equipment.CottonCloth;
import com.cumt.game.domain.equipment.IronSword;

/**
 * 哥布林头领，继承自哥布林
 * Created by 雷祥 on 2017/6/12.
 */

public class HeaderGoblin extends Goblin {
    public HeaderGoblin(){
        cloth = new CottonCloth();
        weapon = new IronSword();
    }
}
