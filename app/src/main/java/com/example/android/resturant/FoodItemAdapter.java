package com.example.android.resturant;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Eloyjaws on 06/22/17.
 */

public class FoodItemAdapter extends ArrayAdapter<FoodItem>{

    public FoodItemAdapter(Activity context, ArrayList<FoodItem> items){
        super(context, 0, items);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
// Check if the existing view is being reused, otherwise inflate the view
        View gridItemView = convertView;
        if (gridItemView == null) {
            gridItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.item_card, parent, false);
        }

        FoodItem currentItem = getItem(position);

        TextView itemName = (TextView) gridItemView.findViewById(R.id.food_name);
        itemName.setText(currentItem.getItemName());

        TextView itemPrice = (TextView) gridItemView.findViewById(R.id.food_price);
        itemPrice.setText((""+currentItem.getPrice()));

        ImageView imageIcon = (ImageView) gridItemView.findViewById(R.id.food_image);

        if (currentItem.hasImage()) {
            imageIcon.setVisibility(View.VISIBLE);
            imageIcon.setImageResource(currentItem.getImageResourceId());
        } else {
            //set default image for random food item
            imageIcon.setVisibility(View.GONE);
        }

        return gridItemView;
    }
}
