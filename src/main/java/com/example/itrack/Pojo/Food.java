package com.example.itrack.Pojo;

public class Food {
    private int id;
    private String name;
    private int calories;
    private int protein;
    private int fat;
    private int carbs;

    public Food(int id, String name, int calories, int protein, int fat, int carbs) {
        this.id = id;
        this.name = name;
        this.calories = calories;
        this.protein = protein;
        this.fat = fat;
        this.carbs = carbs;
    }

    // Getters

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }

    public int getProtein() {
        return protein;
    }

    public int getFat() {
        return fat;
    }

    public int getCarbs() {
        return carbs;
    }

    @Override
    public String toString() {
        return name;
    }
}
