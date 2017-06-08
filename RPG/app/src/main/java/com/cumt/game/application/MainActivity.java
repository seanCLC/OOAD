package com.cumt.game.application;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.cumt.game.repository.DataBaseHelper;


public class MainActivity extends AppCompatActivity {
    private DataBaseHelper dataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataBaseHelper=new DataBaseHelper(this);
        SQLiteDatabase db= dataBaseHelper.getWritableDatabase();
        db.close();


    }
    //个人信息的点击事件
    public void infoClick(View view){
        Intent intent = new Intent(this,PersonInfoActivity.class);
        startActivity(intent);
    }
    //商城按钮的点击事件
    public void shopClick(View view){
        Intent intent = new Intent(this,ShopActivity.class);
        startActivity(intent);
    }
    //战斗按钮的点击事件
    public void fightClick(View view){
        Intent intent = new Intent(this,MapListActivity.class);
        startActivity(intent);
    }
}
