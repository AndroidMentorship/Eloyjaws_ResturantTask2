package com.example.android.resturant;

import static android.R.attr.category;

/**
 * Created by Eloyjaws on 06/22/17.
 */

public class FoodItem {
    private String mItemName;
    private int mCategory;
    private int mPrice;
    public static final int NO_IMAGE_RESOURCE = -1;
    private int mImageResourceId = NO_IMAGE_RESOURCE;

    public FoodItem(String itemName, int category, int price){
        mItemName = itemName;
        mCategory = category;
        mPrice = price;
    }

    public FoodItem(String itemName, int category, int price, int imageResourceId){
        mItemName = itemName;
        mCategory = category;
        mPrice = price;
        mImageResourceId = imageResourceId;
    }

    public String getItemName(){
        return mItemName;
    }

    public int getCategory() {
        return mCategory;
    }

    public int getPrice() {
        return mPrice;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_RESOURCE;
    }
}
