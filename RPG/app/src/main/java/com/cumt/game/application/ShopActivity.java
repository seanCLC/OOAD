package com.cumt.game.application;

import android.content.Intent;
import android.renderscript.Sampler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.view.View;
import android.view.View.OnClickListener;
import com.cumt.game.domain.entity.ItemInfo;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

public class ShopActivity extends AppCompatActivity implements OnClickListener{

    private ItemInfo itemInfo;
    private ListView shopLv;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        initView();
        itemInfo = new ItemInfo("金剑", 100, 20, 20);
//        findViewById(R.id.rl).setOnClickListener(this);
//        TextView mLifeTV = (TextView) findViewById(R.id.tv_life);
//        TextView mNameTV = (TextView) findViewById(R.id.tv_name);
//        TextView mSpeedTV = (TextView) findViewById(R.id.tv_speed);
//        TextView mAttackTV = (TextView) findViewById(R.id.tv_attack);
//        // TextView显示字符串,这里传入int值编译不会报错,运行会出错
//        mLifeTV.setText("生命值+" + itemInfo.getLife());
//        mNameTV.setText(itemInfo.getName() + "");
//        mSpeedTV.setText("敏捷度+" + itemInfo.getSpeed());
//        mAttackTV.setText("攻击力+" + itemInfo.getAcctack());

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


    // 初始化控件
    private void initView() {
        shopLv = (ListView) findViewById(R.id.ShopLV);//列表
        ArrayList<HashMap<String, String>> mylist = new ArrayList<HashMap<String, String>>();
        try {
            InputStream is = getResources().openRawResource(R.raw.data);
            byte [] buffer = new byte[is.available()] ;
            is.read(buffer);
            String json = new String(buffer,"utf-8");
            JSONArray jsonArray=new JSONArray(json);
            for(int i=0;i<jsonArray.length();i++){
                HashMap<String, String> map = new HashMap<String, String>();
                JSONObject jo=jsonArray.getJSONObject(i);
                Log.d("shop====",jo.getString("name"));
                Log.d("shop====",jo.getString("life"));
                Log.d("shop====",jo.getString("attack"));
                Log.d("shop====",jo.getString("speed"));
//                map.put("EQname", "1");
//                map.put("EQlife","1");
//                map.put("EQattack","1");
//                map.put("EQspeed","1");
                map.put("EQname", jo.getString("name"));
                map.put("EQlife",jo.getString("life"));
                map.put("EQattack",jo.getString("attack"));
                map.put("EQspeed",jo.getString("speed"));
                mylist.add(map);
            }

            is.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


        //生成适配器，数组===》ListItem
        SimpleAdapter mSchedule = new SimpleAdapter(this, mylist,
                R.layout.shop_list,
                new String[] {"EQname", "EQlife","EQattack","EQspeed"},
                new int[] {R.id.tv_EQname,R.id.tv_EQlife,R.id.tv_EQattack,R.id.tv_EQspeed});
        shopLv.setAdapter(mSchedule);
    }


}
