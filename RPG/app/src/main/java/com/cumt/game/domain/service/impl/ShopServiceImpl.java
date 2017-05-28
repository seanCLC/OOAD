package com.cumt.game.domain.service.impl;

import android.content.Context;
import android.content.res.Resources;

import com.cumt.game.application.R;
import com.cumt.game.domain.entity.ItemInfo;
import com.cumt.game.domain.service.ShopService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by hui on 2017/5/28.
 */

public class ShopServiceImpl implements ShopService {
    @Override
    public List<ItemInfo> getEquipmentList() {
        List<ItemInfo> equipmentList=new ArrayList<>();
        return equipmentList;
    }


}
