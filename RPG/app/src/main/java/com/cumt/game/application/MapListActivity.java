package com.cumt.game.application;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapListActivity extends AppCompatActivity {

    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_list);
        listView = (ListView) findViewById(R.id.map_listView);
        SimpleAdapter adapter = new SimpleAdapter(this,getData(),R.layout.list_map,new String[] {"name","img"},new int[]{R.id.map_list_name,R.id.map_list_img});
        listView.setAdapter(adapter);

    }

    protected List<Map<String,Object>> getData(){
        List<Map<String,Object>> list = new ArrayList<>();
        Map<String,Object> map1 = new HashMap<>();
        map1.put("name","哥布林森林");
        map1.put("img",R.drawable.baby);

        list.add(map1);
        Map<String,Object> map2 = new HashMap<>();

        map2.put("name","牛头峡谷");
        map2.put("img",R.drawable.baby);

        list.add(map2);

        return list;
    }


}

