package com.example.hw2_v2;

public class Food {
    // attributes
    private int foodId;
    private String foodName;
    private double foodCost;
    private String foodDescription;
    private int foodPicture;
    private int foodCount;

    // constructor
    public Food(int foodId, String foodName, double foodCost, String foodDescription, int foodPicture, int foodCount) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodCost = foodCost;
        this.foodDescription = foodDescription;
        this.foodPicture = foodPicture;
        this.foodCount = foodCount;
    }

    // getters and setters
    public int getFoodId() {
        return foodId;
    }

    public void setFoodId(int foodId) {
        this.foodId = foodId;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public double getFoodCost() {
        return foodCost;
    }

    public void setFoodCost(double foodCost) {
        this.foodCost = foodCost;
    }

    public String getFoodDescription() {
        return foodDescription;
    }

    public void setFoodDescription(String foodDescription) {
        this.foodDescription = foodDescription;
    }

    public int getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(int foodPicture) {
        this.foodPicture = foodPicture;
    }

    public int getFoodCount() {
        return foodCount;
    }

    public void setFoodCount(int foodCount) {
        this.foodCount = foodCount;
    }
}
