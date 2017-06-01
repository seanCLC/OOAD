package com.cumt.game.domain.repository;

import android.content.Context;

import com.cumt.game.domain.entity.ItemInfo;

import java.util.List;

/**
 * Created by hui on 2017/6/1.
 */

public interface ShopDao {
    /**
     * 根据相应实体插入
     */
    public void insert(Object obj,Class<?> clazz);
    /**
     * 根据相应实体id插入
     */
    public void delete(int id);

    /**
     * 根据相应实体更新数据
     */
    public void update(Object obj,Class<?> clazz);

    /**
     * 根据相应实体查询数据
     */
    public List<Object> queryAll(Class<?> clazz);

}
