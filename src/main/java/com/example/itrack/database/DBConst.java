package com.example.itrack.database;

public class DBConst {

    //person info
    public static final String TABLE_PERSON_INFO = "person";
    public static final String PERSON_COLUMN_ID = "id";
    public static final String PERSON_COLUMN_NAME = "name";
    public static final String PERSON_COLUMN_AGE = "age";
    public static final String PERSON_COLUMN_GENDER = "gender";
    public static final String PERSON_COLUMN_HEIGHT = "height";
    public static final String PERSON_COLUMN_WEIGHT = "weight";
    public static final String PERSON_COLUMN_GOAL_WEIGHT = "goalWeight";

    public static final String CREATE_TABLE_PERSON_INFO =
            "CREATE TABLE IF NOT EXISTS " + TABLE_PERSON_INFO + " (" +
                    PERSON_COLUMN_ID + " INT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
                    PERSON_COLUMN_NAME + " VARCHAR(50) NOT NULL, " +
                    PERSON_COLUMN_AGE + " INT NOT NULL, " +
                    PERSON_COLUMN_GENDER + " VARCHAR(6) NOT NULL, " +
                    PERSON_COLUMN_HEIGHT + " INT NOT NULL, " +
                    PERSON_COLUMN_WEIGHT + " INT NOT NULL, " +
                    PERSON_COLUMN_GOAL_WEIGHT + " INT NOT NULL " + ");";


    //meal info
    public static final String TABLE_MEAL = "meals";
    public static final String MEAL_COLUMN_ID = "id";
    public static final String MEAL_COLUMN_CALORIES = "calories";
    public static final String MEAL_COLUMN_NAME = "name";
    public static final String MEAL_COLUMN_PROTEIN = "protein";
    public static final String MEAL_COLUMN_FAT = "fat";
    public static final String MEAL_COLUMN_CARBS = "carbs";
    public static final String MEAL_COLUMN_TIMESTAMP = "meal_timestamp";

    public static final String CREATE_TABLE_MEAL =
            "CREATE TABLE IF NOT EXISTS " + TABLE_MEAL + " (" +
                    MEAL_COLUMN_ID + " INT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
                    MEAL_COLUMN_NAME + " VARCHAR(50) NOT NULL, " +
                    MEAL_COLUMN_CALORIES + " INT NOT NULL, " +
                    MEAL_COLUMN_PROTEIN + " INT NOT NULL, " +
                    MEAL_COLUMN_FAT + " INT NOT NULL, " +
                    MEAL_COLUMN_CARBS + " INT NOT NULL, " +
                    MEAL_COLUMN_TIMESTAMP + " TIMESTAMP " +
                    ");";




    public static final String TABLE_FOOD = "food";
    public static final String FOOD_COLUMN_ID = "id";
    public static final String FOOD_COLUMN_CALORIES = "calories";
    public static final String FOOD_COLUMN_NAME = "name";
    public static final String FOOD_COLUMN_PROTEIN = "protein";
    public static final String FOOD_COLUMN_FAT = "fat";
    public static final String FOOD_COLUMN_CARBS = "carbs";

    public static final String CREATE_TABLE_FOOD =
            "CREATE TABLE IF NOT EXISTS " + TABLE_FOOD + " (" +
                    FOOD_COLUMN_ID + " INT AUTO_INCREMENT NOT NULL PRIMARY KEY, " +
                    FOOD_COLUMN_NAME + " VARCHAR(50) NOT NULL, " +
                    FOOD_COLUMN_CALORIES + " INT NOT NULL, " +
                    FOOD_COLUMN_PROTEIN + " INT NOT NULL, " +
                    FOOD_COLUMN_FAT + " INT NOT NULL, " +
                    FOOD_COLUMN_CARBS + " INT NOT NULL " + ");";





}
