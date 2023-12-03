package com.example.itrack.database;

import javafx.scene.chart.XYChart;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.jar.JarEntry;

import static com.example.itrack.database.Const.*;

public class Database {

    /**
     * Singleton Design Pattern
     */

    private static Database instance;
    //make Connection
    private Connection connection = null;
    private  String[] dbLogin = new String[4];

    private Database()  {
        try(BufferedReader br = new BufferedReader(new FileReader("db_login.txt"))){
            dbLogin[0] = br.readLine().trim(); // host
            dbLogin[1] = br.readLine().trim(); // user
            dbLogin[2] = br.readLine().trim(); // pass
            dbLogin[3] = br.readLine().trim(); // name
        }catch(IOException ioException){
            ioException.printStackTrace();
        }

        System.out.println(dbLogin[0] + "\n" + dbLogin[1]+ "\n" + dbLogin[2]+ "\n" + dbLogin[3]);


        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/"+ dbLogin[3] +
                                    "?serverTimezone=UTC",
                            dbLogin[1],
                            dbLogin[2]);
            System.out.println("Created Connection!");

            createTables(DBConst.TABLE_PERSON_INFO, DBConst.CREATE_TABLE_PERSON_INFO, connection);
            createTables(DBConst.TABLE_MEAL, DBConst.CREATE_TABLE_MEAL, connection);
            createTables(DBConst.TABLE_FOOD, DBConst.CREATE_TABLE_FOOD, connection);
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

    private void createTables(String tableName, String tableQuery, Connection connection )
            throws SQLException{
        Statement createTable;
        DatabaseMetaData it = connection.getMetaData();

        ResultSet resultSet = it.getTables(dbLogin[1]+"projects", null, tableName, null);

        if(resultSet.next()){
            System.out.println(tableName + "table already exists");
        }else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }
}
