package com.example.itrack.database;

import javafx.scene.chart.XYChart;

import java.sql.*;

import static com.example.itrack.database.Const.*;

public class Database {

    /**
     * Singleton Design Pattern
     */

    private static Database instance;
    //make Connection
    private Connection connection;

    private Database() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/" + DB_NAME +
                            "?serveTimezone=UTC",
                            DB_USER,
                            DB_PASS);
            System.out.println("Created Connection");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static Database getInstance(){
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
