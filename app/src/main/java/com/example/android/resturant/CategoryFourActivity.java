package com.example.android.resturant;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import java.util.ArrayList;

public class CategoryFourActivity extends AppCompatActivity {

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.grid_view);
        getSupportActionBar().setTitle(getString(R.string.category_four));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
        foodItems.add(new FoodItem("Soft Drinks", 4, 100, R.drawable.soft_drinks));
        foodItems.add(new FoodItem("CHi Tetra-pak Drinks", 4, 250, R.drawable.tetra_pak));
        foodItems.add(new FoodItem("Energy Drinks", 4, 350, R.drawable.energy));
        foodItems.add(new FoodItem("krushers", 4, 500, R.drawable.krushers2));

        FoodItemAdapter adapter = new FoodItemAdapter(this, foodItems);


        GridView gridview = (GridView) findViewById(R.id.rootgridview);

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FoodItem currentItem = foodItems.get(i);
                Intent intent = new Intent(CategoryFourActivity.this, OrderMenuItemActivity.class);
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
