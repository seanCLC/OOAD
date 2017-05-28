package com.cumt.game.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.cumt.game.domain.entity.ItemInfo;

import java.io.InputStream;

public class ShopActivity extends AppCompatActivity implements OnClickListener{

    private ItemInfo itemInfo;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        itemInfo = new ItemInfo("金剑", 100, 20, 20);
        findViewById(R.id.rl).setOnClickListener(this);
        TextView mLifeTV = (TextView) findViewById(R.id.tv_life);
        TextView mNameTV = (TextView) findViewById(R.id.tv_name);
        TextView mSpeedTV = (TextView) findViewById(R.id.tv_speed);
        TextView mAttackTV = (TextView) findViewById(R.id.tv_attack);
        // TextView显示字符串,这里传入int值编译不会报错,运行会出错
        mLifeTV.setText("生命值+" + itemInfo.getLife());
        mNameTV.setText(itemInfo.getName() + "");
        mSpeedTV.setText("敏捷度+" + itemInfo.getSpeed());
        mAttackTV.setText("攻击力+" + itemInfo.getAcctack());
        try {
            InputStream is = getResources().openRawResource(R.raw.data);
            byte [] buffer = new byte[is.available()] ;
            is.read(buffer);
            String json = new String(buffer,"utf-8");
            System.out.println(json);
            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.rl:
                Intent intent = new Intent();
                intent.putExtra("equipment", itemInfo);
                setResult(1, intent);
                finish();
                break;
        }
    }
}
