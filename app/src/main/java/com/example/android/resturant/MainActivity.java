package com.example.android.resturant;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import static android.R.attr.category;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent intent  = new Intent(MainActivity.this, CategoryThreeActivity.class);
                startActivity(intent);
            }
        });

        categoryFour.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, CategoryFourActivity.class);
                startActivity(intent);
            }
        });

        categoryFive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, CategoryFiveActivity.class);
                startActivity(intent);
            }
        });

        categorySix.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent  = new Intent(MainActivity.this, CategorySixActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id ==R.id.auth){
            Intent intent = new Intent(MainActivity.this, AuthActivity.class);
            startActivity(intent);
        }
        if (id ==R.id.cart){
            Intent intent = new Intent(MainActivity.this, ViewOrderSummaryActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}
