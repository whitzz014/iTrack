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
    private Connection connection = null;

    private Database() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager
                    .getConnection("jdbc:mysql://localhost/"+ DB_NAME +
                                    "?serverTimezone=UTC",
                            DB_USER,
                            DB_PASS);
            System.out.println("Created Connection!");

            createTables(DBConst.TABLE_ACCOUNT_INFO, DBConst.CREATE_TABLE_ACCOUNT_INFO, connection);
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

        ResultSet resultSet = it.getTables("bwhitsonprojects", null, tableName, null);

        if(resultSet.next()){
            System.out.println(tableName + "table already exists");
        }else{
            createTable = connection.createStatement();
            createTable.execute(tableQuery);
            System.out.println("The " + tableName + " table has been created");
        }
    }
}
