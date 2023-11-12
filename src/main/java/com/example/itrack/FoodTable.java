package com.example.itrack;

import com.example.itrack.database.DBConst;
import com.example.itrack.database.Database;
import com.example.itrack.Pojo.Food;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class FoodTable {
    ArrayList<Food> foods;
    Database db = Database.getInstance();

    public ArrayList<Food> getAllFoods() {
        String query = "SELECT * FROM " + DBConst.TABLE_FOOD;
        foods = new ArrayList<>();
        try {
            Statement getFoods = db.getConnection().createStatement();
            ResultSet data = getFoods.executeQuery(query);
            while (data.next()) {
                foods.add(new Food(
                        data.getInt(DBConst.FOOD_COLUMN_ID),
                        data.getString(DBConst.FOOD_COLUMN_NAME),
                        data.getInt(DBConst.FOOD_COLUMN_CALORIES),
                        data.getInt(DBConst.FOOD_COLUMN_PROTEIN),
                        data.getInt(DBConst.FOOD_COLUMN_FAT),
                        data.getInt(DBConst.FOOD_COLUMN_CARBS)
                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return foods;
    }

    public Food getFood(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_FOOD +
                " WHERE " + DBConst.FOOD_COLUMN_ID + " = " + id;

        try {
            Statement getFood = db.getConnection().createStatement();

            ResultSet data = getFood.executeQuery(query);
            if (data.next()) {
                return new Food(
                        data.getInt(DBConst.FOOD_COLUMN_ID),
                        data.getString(DBConst.FOOD_COLUMN_NAME),
                        data.getInt(DBConst.FOOD_COLUMN_CALORIES),
                        data.getInt(DBConst.FOOD_COLUMN_PROTEIN),
                        data.getInt(DBConst.FOOD_COLUMN_FAT),
                        data.getInt(DBConst.FOOD_COLUMN_CARBS)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
