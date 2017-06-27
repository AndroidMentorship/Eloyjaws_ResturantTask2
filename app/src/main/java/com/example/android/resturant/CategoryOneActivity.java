package com.example.android.resturant;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;

public class CategoryOneActivity extends AppCompatActivity {

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu_two, menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        getSupportActionBar().setTitle(getString(R.string.category_one));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
        foodItems.add(new FoodItem("Amala", 1, 100, R.drawable.amala));
        foodItems.add(new FoodItem("semo", 1, 200, R.mipmap.ic_launcher_round));
        foodItems.add(new FoodItem("Pounded Yam", 1, 500, R.drawable.amala));

        FoodItemAdapter adapter = new FoodItemAdapter(this, foodItems);


        GridView gridview = (GridView) findViewById(R.id.rootgridview);

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FoodItem currentItem = foodItems.get(i);
                Intent intent = new Intent(CategoryOneActivity.this, OrderMenuItemActivity.class);
                intent.putExtra("itemName", currentItem.getItemName());
                intent.putExtra("itemPrice", ""+currentItem.getPrice());
                intent.putExtra("itemCategory",""+currentItem.getCategory());
                if (currentItem.hasImage()){
                    //pass image
                    int imageId = currentItem.getImageResourceId();
                    intent.putExtra("foodPic", imageId);
                } else {
                    //pass default image
                    int imageId = R.drawable.amala;
                    intent.putExtra("foodPic", imageId);
                }
                startActivity(intent);
            }
        });

    }
}
