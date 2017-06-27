package com.example.android.resturant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OrderMenuItemActivity extends AppCompatActivity {

    int quantity = 1;
    String userExtrasValue = "";
    ImageView foodImage;
    TextView itemNameTextView, priceTextView, quantityTextView;
    EditText userExtras;
    Button increment, decrement, addOrderNutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_menu_item);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        final String itemName = extras.getString("itemName");
        final String itemPrice = extras.getString("itemPrice") + " Per Serving";
        final String itemCategory = extras.getString("itemCategory");
        final int foodPic = extras.getInt("foodPic");
        Log.i("OrderMenu Activity", "item cat: " + itemCategory);

        foodImage = (ImageView) findViewById(R.id.food_image);
        itemNameTextView = (TextView) findViewById(R.id.item_name);
        priceTextView = (TextView) findViewById(R.id.item_price);
        decrement = (Button) findViewById(R.id.decrement);
        increment = (Button) findViewById(R.id.increment);

        quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        userExtras = (EditText) findViewById(R.id.extra_text);
        addOrderNutton = (Button) findViewById(R.id.addToOrderMenuButton);

        //edit the layout
        itemNameTextView.setText(itemName);
        priceTextView.setText(itemPrice);
        foodImage.setImageResource(foodPic);

        /**
         * This method is called when the order button is clicked.
         */
        addOrderNutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                userExtras = (EditText) findViewById(R.id.extra_text);
                userExtrasValue = userExtras.getText().toString();
                Intent intent = new Intent(OrderMenuItemActivity.this, ViewOrderSummaryActivity.class);
                intent.putExtra("userExtras", userExtrasValue);
                intent.putExtra("itemName", itemName);
                intent.putExtra("itemPrice", itemPrice);
                intent.putExtra("itemCategory", itemCategory);
                intent.putExtra("foodpic", foodPic);
                intent.putExtra("quantity", quantity);

                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Add to Order button clicked", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * This method displays the givenn quantity value on the screen.
     */
    private void displayQuantity(int servingSize) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + servingSize);
    }

    /**
     * This method is called when the decrement button is clicked.
     */
    public void decrement(View view) {
        if (quantity <= 1) {
            String message = "You cannot order for less than one serving";
            Toast alert = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            alert.show();
            return;
        }
        quantity -= 1;
        displayQuantity(quantity);
    }

    /**
     * This method is called when the increment button is clicked.
     */
    public void increment(View view) {
        if (quantity >= 15) {
            String message = "Pls, contact us for orders above 15 servings";
            Toast alert = Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT);
            alert.show();
            return;
        }
        quantity += 1;
        displayQuantity(quantity);
    }


}
