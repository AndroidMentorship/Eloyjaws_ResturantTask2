package com.example.android.resturant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.category;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        ActionBar actionBar = getSupportActionBar();
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        actionBar.setTitle(getString(R.string.app_name));

        final TextView categoryOne = (TextView) findViewById(R.id.category_one);
        final TextView categoryTwo = (TextView) findViewById(R.id.category_two);
        final TextView categoryThree = (TextView) findViewById(R.id.category_three);
        TextView categoryFour = (TextView) findViewById(R.id.category_four);
        TextView categoryFive = (TextView) findViewById(R.id.category_five);
        TextView categorySix = (TextView) findViewById(R.id.category_six);

        categoryOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, CategoryOneActivity.class);
                startActivity(intent);
            }
        });

        categoryTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, CategoryTwoActivity.class);
                startActivity(intent);
            }
        });

        categoryThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "You clicked category 3", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}
