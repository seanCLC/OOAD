package com.cumt.game.application;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void infoClick(View view){
        Intent intent = new Intent(this,PersonInfoActivity.class);
        startActivity(intent);
    }
    public void shopClick(View view){
        Intent intent = new Intent(this,ShopActivity.class);
        startActivity(intent);
    }
}
