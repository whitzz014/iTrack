package com.example.itrack.database;

import java.sql.*;

public class Database {
    /**
     * Singleton Design Pattern
     */

    private static Database instance;
    //make Connection
    private Connection connection;

    private Database() {}

}
