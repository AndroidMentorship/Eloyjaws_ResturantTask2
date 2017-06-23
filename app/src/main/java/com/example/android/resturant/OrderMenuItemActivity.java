package com.example.android.resturant;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class OrderMenuItemActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_menu_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
