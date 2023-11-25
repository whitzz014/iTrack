package com.example.itrack.Tables;

import com.example.itrack.Pojo.Food;
import com.example.itrack.Pojo.PersonInfo;
import com.example.itrack.database.DBConst;
import com.example.itrack.database.Database;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class PersonTable {
    Database db = Database.getInstance();
    ArrayList<PersonInfo> person;

    public ArrayList<PersonInfo> getAllPersonInfo() {
        String query = "SELECT * FROM " + DBConst.TABLE_PERSON_INFO;
        person = new ArrayList<>();
        try {
            Statement getPerson = db.getConnection().createStatement();
            ResultSet data = getPerson.executeQuery(query);
            while (data.next()) {
                person.add(new PersonInfo(
                        data.getString(DBConst.PERSON_COLUMN_NAME),
                        data.getInt(DBConst.PERSON_COLUMN_AGE),
                        data.getString(DBConst.PERSON_COLUMN_GENDER),
                        data.getInt(DBConst.PERSON_COLUMN_HEIGHT),
                        data.getInt(DBConst.PERSON_COLUMN_WEIGHT),
                        data.getInt(DBConst.PERSON_COLUMN_GOAL_WEIGHT)

                ));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return person;
    }


    public PersonInfo getPersonInfo(int id) {
        String query = "SELECT * FROM " + DBConst.TABLE_PERSON_INFO +
        " WHERE " + DBConst.PERSON_COLUMN_ID + " = " + id;
        try {
            Statement getPerson = db.getConnection().createStatement();

            ResultSet data = getPerson.executeQuery(query);
            if (data.next()) {
                return new PersonInfo(
                       data.getString(DBConst.PERSON_COLUMN_NAME),
                        data.getInt(DBConst.PERSON_COLUMN_AGE),
                        data.getString(DBConst.PERSON_COLUMN_GENDER),
                        data.getInt(DBConst.PERSON_COLUMN_HEIGHT),
                        data.getInt(DBConst.PERSON_COLUMN_WEIGHT),
                        data.getInt(DBConst.PERSON_COLUMN_GOAL_WEIGHT)
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
