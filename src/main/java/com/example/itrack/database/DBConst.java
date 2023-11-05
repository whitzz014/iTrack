package com.example.itrack.database;

public class DBConst {

    //account info
    public static final String TABLE_ACCOUNT_INFO = "account";
    public static final String ACCOUNT_COLUMN_ID = "id";
    public static final String ACCOUNT_COLUMN_NAME = "name";
    public static final String ACCOUNT_COLUMN_EMAIL = "email";
    public static final String ACCOUNT_COLUMN_PASS = "password";

    public static final String CREATE_TABLE_ACCOUNT_INFO =
            "CREATE TABLE IF NOT EXISTS " + TABLE_ACCOUNT_INFO + " (" +
                    ACCOUNT_COLUMN_ID + " INT AUTO_INCREMENT PRIMARY KEY, " +
                    ACCOUNT_COLUMN_NAME + " VARCHAR(255) NOT NULL, " +
                    ACCOUNT_COLUMN_EMAIL + " VARCHAR(255) NOT NULL, " +
                    ACCOUNT_COLUMN_PASS + " VARCHAR(255) NOT NULL" +
                    ")";



    //person info
    public static final String TABLE_PERSON_INFO = "person";
    public static final String PERSON_COLUMN_ID = "id";
    public static final String PERSON_COLUMN_AGE = "age";
    public static final String PERSON_COLUMN_HEIGHT = "height";
    public static final String PERSON_COLUMN_WEIGHT = "weight";
    public static final String PERSON_COLUMN_GOAL_WEIGHT = "goalWeight";

    public static final String CREATE_TABLE_PERSON_INFO =
            "CREATE TABLE IF NOT EXISTS " + TABLE_PERSON_INFO + " (" +
                    PERSON_COLUMN_ID + " INT AUTO_INCREMENT PRIMARY KEY, " +
                    PERSON_COLUMN_AGE + " INT NOT NULL, " +
                    PERSON_COLUMN_HEIGHT + " INT NOT NULL, " +
                    PERSON_COLUMN_WEIGHT + " INT NOT NULL, " +
                    PERSON_COLUMN_GOAL_WEIGHT + " INT NOT NULL " +
                    ")";









}
