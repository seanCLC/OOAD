package com.cumt.game.domain.repository.impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.cumt.game.domain.repository.DataBaseHelper;
import com.cumt.game.domain.repository.ShopDao;

import java.util.List;

/**
 * Created by hui on 2017/6/1.
 */

public class ShopDapImpl implements ShopDao {
    private DataBaseHelper dataBaseHelper;
    private SQLiteDatabase db;
    public ShopDapImpl(Context context){
        dataBaseHelper=new DataBaseHelper(context);
        db= dataBaseHelper.getWritableDatabase();
    }
    @Override
    public void insert(Object obj, Class<?> clazz) {
        // 用来装载要插入的数据的 Map<列名, 列的值>
        ContentValues values = new ContentValues();
        values.put("name", "金剑");
        values.put("acctack", 20);
        values.put("life", 20);
        values.put("speed", 10);
        System.out.println(db.insert("shop", null, values));
    }

    @Override
    public void delete(int id) {
        // 按条件删除指定表中的数据, 返回受影响的行数
        int count = db.delete("account", "_id=?", new String[] { id + "" });
        db.close();
    }

    @Override
    public void update(Object obj, Class<?> clazz) {
        ContentValues values = new ContentValues(); // 要修改的数据
        values.put("name", "name");
        values.put("balance", "balance");
        int count = db.update("account", values, "_id=?",
                new String[] { "balance" + "" }); // 更新并得到行数
        db.close();
    }

    @Override
    public List<Object> queryAll(Class<?> clazz) {
        return null;
    }
}
