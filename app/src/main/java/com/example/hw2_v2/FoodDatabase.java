package com.example.hw2_v2;

import android.util.Log;

import java.util.ArrayList;

public class FoodDatabase {

    // array list for menu
    public static ArrayList<Food> menuArrayList = new ArrayList<>();
    public static ArrayList<Food> orderArrayList = new ArrayList<>();

    // for first run
    public static void generateMenuArrayList() {
        menuArrayList.add(new Food(0, "Boof Burger", 5.95, "Sesame bun with lettuce, tomato, onion, pickles, beef, tomato sauce and salad dressing.", R.drawable.burger_1, 0));
        menuArrayList.add(new Food(1, "Chezeburger", 3.95, "Sesame bun with pickles, cheese, beef patty, tomato sauce and mustard.", R.drawable.burger_2, 0));
        menuArrayList.add(new Food(2, "Chikun Burger", 5.95, "Sesame bun with lettuce, tomato, chicken breast and salad dressing.", R.drawable.burger_4, 0));
        menuArrayList.add(new Food(3, "Meaty Burger", 7.95, "Crispy bun with pickles, bacon, cheese, beef patty, BBQ sauce and mustard.", R.drawable.burger_3, 0));
        menuArrayList.add(new Food(4, "Chips (S)", 1.95, "Standard cup of thick cut chips with chicken salt.", R.drawable.chips_1, 0));
        menuArrayList.add(new Food(5, "Chips (L)", 3.95, "Box of thick cut chips with chicken salt. Comes with choice of gravy or melted cheese", R.drawable.chips_2, 0));
        menuArrayList.add(new Food(6, "Coca Cola (S)", 1.50, "Standard cup of coke with ice.", R.drawable.drink_1, 0));
        menuArrayList.add(new Food(7, "Water 600mL", 2.00, "Sealed bottle of Mount Franklin water.", R.drawable.drink_2, 0));
        menuArrayList.add(new Food(8, "Strawberry Shake", 6.50, "Strawberry shake with cup lined with strawberry syrup, topped with KitKat crumbs.", R.drawable.drink_3, 0));
        menuArrayList.add(new Food(9, "Frozen Fanta", 2.00, "Cup of frozen Fanta, raspberry flavour. It's actually a spider.", R.drawable.frozen_1, 0));
        menuArrayList.add(new Food(10, "Hash Brown", 0.50, "1 hash brown. Good for a quick breakfast.", R.drawable.hash_1, 0));
        menuArrayList.add(new Food(11, "Soft Serve", 0.80, "Classic soft serve.", R.drawable.icecream_1, 0));
        menuArrayList.add(new Food(12, "Chocolate Sundae", 1.95, "Classic soft serve in a cup, topped with chocolate syrup.", R.drawable.icecream_2, 0));
        menuArrayList.add(new Food(13, "Nuggets", 3.95, "6 chicken nuggets. Comes with choice of BBQ sauce or aioli sauce.", R.drawable.nugget_1, 0));
        menuArrayList.add(new Food(14, "Piklets", 5.00, "4 fluffy piklets. Comes with maple syrup and butter spread.", R.drawable.piklet_1, 0));
        menuArrayList.add(new Food(15, "Toastie", 3.00, "2 halves of toasted bread with tomato, ham and cheese.", R.drawable.toastie_1, 0));
        menuArrayList.add(new Food(16, "Wrap", 2.50, "Wrap with lettuce, cheese, chicken breast and sweet chili sauce.", R.drawable.wrap_1, 0));
    }

    // for remainder runs
    public static ArrayList<Food> getMenuArrayList() {
        if (menuArrayList.isEmpty()) {
            generateMenuArrayList();
        }
        return menuArrayList;
    }

    // get the ordered items
    public static ArrayList<Food> getOrderArrayList() {
        orderArrayList.clear();
        for (Food f : menuArrayList) {
            if (f.getFoodCount() > 0) {
                orderArrayList.add(f);
            }
        }
        return orderArrayList;
    }

    // for food detail activity
    public static Food getMenuFoodById(int foodId) {
        return menuArrayList.get(foodId);
    }

}
