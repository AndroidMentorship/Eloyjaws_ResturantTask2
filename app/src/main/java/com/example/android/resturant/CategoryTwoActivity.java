package com.example.android.resturant;

        import android.content.Intent;
        import android.support.v4.app.NavUtils;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.MenuItem;
        import android.view.View;
        import android.widget.AdapterView;
        import android.widget.GridView;
        import android.widget.Toast;

        import java.util.ArrayList;

public class CategoryTwoActivity extends AppCompatActivity {

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
        getSupportActionBar().setTitle(getString(R.string.category_two));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final ArrayList<FoodItem> foodItems = new ArrayList<FoodItem>();
        foodItems.add(new FoodItem("Jollof Rice", 2, 200, R.drawable.jollof));
        foodItems.add(new FoodItem("Fried Rice", 2, 200, R.drawable.fried_rice));
        foodItems.add(new FoodItem("Coconut Rice", 2, 500, R.drawable.coconut_rice));
        foodItems.add(new FoodItem("White Rice", 2, 100, R.drawable.white_rice));
        foodItems.add(new FoodItem("Rice Balls", 2, 50, R.drawable.rice_balls));

        FoodItemAdapter adapter = new FoodItemAdapter(this, foodItems);


        GridView gridview = (GridView) findViewById(R.id.rootgridview);

        gridview.setAdapter(adapter);

        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                FoodItem currentItem = foodItems.get(i);
                Intent intent = new Intent(CategoryTwoActivity.this, OrderMenuItemActivity.class);
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
