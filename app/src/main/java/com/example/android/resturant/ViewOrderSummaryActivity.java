package com.example.android.resturant;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ViewOrderSummaryActivity extends AppCompatActivity {
    TextView priceTv, quantityTv, nameTv;
    ImageView foodPicIv;
    String itemName;
    String itemPrice;
    String itemCategory;
    int foodPic;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_summary);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            //Dummy data for the icon on home page
            itemName = "Item Name";
            itemPrice = "Price: N500";
            itemCategory = "1";
            foodPic = R.drawable.amala;
            quantity = 3;
//            return;
        } else {

            itemName = extras.getString("itemName");
            itemPrice = extras.getString("itemPrice");
            itemCategory = extras.getString("itemCategory");
            foodPic = extras.getInt("foodPic");
            quantity = extras.getInt("quantity");
        }

        priceTv = (TextView) findViewById(R.id.price_textview);
        quantityTv = (TextView) findViewById(R.id.quantity_textview);
        nameTv = (TextView) findViewById(R.id.name_textview);
        foodPicIv = (ImageView) findViewById(R.id.food_imageview);

        priceTv.setText("Price " + itemPrice);
        quantityTv.setText("Quantity: "+quantity);
        nameTv.setText(itemName);
        foodPicIv.setImageResource(foodPic);

        Button checkoutButton = (Button) findViewById(R.id.checkout_button);
        checkoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ViewOrderSummaryActivity.this, SelectCheckoutOptionActivity.class);
                startActivity(intent);
            }
        });

    }
}