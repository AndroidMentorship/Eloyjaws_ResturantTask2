package com.example.android.resturant;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ViewOrderSummaryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_order_summary);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }

        final String itemName = extras.getString("itemName");
        final String itemPrice = extras.getString("itemPrice");
        final String itemCategory = extras.getString("itemCategory");

        byte[] b = extras.getByteArray("picture");

        Bitmap bmp = BitmapFactory.decodeByteArray(b, 0, b.length);

    }
}
