package com.example.android.resturant;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Toast;

import static android.support.design.widget.Snackbar.make;

public class SelectCheckoutOptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_checkout_option);

        CardView loginCard = (CardView) findViewById(R.id.login_card);
        CardView deliveryCard = (CardView) findViewById(R.id.delivery_card);
        CardView pickupCard = (CardView) findViewById(R.id.pickup_card);

        loginCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AuthActivity.class);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Pls login to checkout", Toast.LENGTH_SHORT).show();
            }
        });

        deliveryCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Snackbar snackbar = Snackbar.make(view, "Delivery Option Selected", Snackbar.LENGTH_SHORT);
                Intent intent = new Intent(getApplicationContext(), DeliveryOptionActivity.class);
                startActivity(intent);
                snackbar.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                }).show();
            }
        });

        pickupCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), PickupActivity.class);
                startActivity(intent);
                final Snackbar snackbar = Snackbar.make(view, "Pickup Selected", Snackbar.LENGTH_SHORT);
                snackbar.setAction("Dismiss", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        snackbar.dismiss();
                    }
                }).show();
            }
        });
    }
}
