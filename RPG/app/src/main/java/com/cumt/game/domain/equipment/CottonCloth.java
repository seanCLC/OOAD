package com.cumt.game.domain.equipment;

/**
 * 棉衣，继承自抽象类Cloth
 * Created by 雷祥 on 2017/6/12.
 */

public class CottonCloth extends Cloth {
    private final int defend = 50;

    @Override
    public int getDefend() {
        return super.getDefend() + defend;
    }
}
