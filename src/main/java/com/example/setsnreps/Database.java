package com.example.setsnreps;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Database {
    public static Connection connect() {
        String url = "jdbc:sqlite:workout_tracker.db"; // creates or opens a database file named `workout_tracker.db`
        Connection conn = null;

        try {
            // opening up the connection
            conn = DriverManager.getConnection(url);
            System.out.println("Connection to SQLite has been established.");
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return conn;

    }

    public static void domainExpansionTABLES(){
        String createSplitDayTable = "CREATE TABLE IF NOT EXISTS sessions (" +
                "sessionID INTEGER PRIMARY KEY, " +
                "exercise TEXT NOT NULL, " +
                "sets INTEGER, " +
                "reps INTEGER, " +
                "weight REAL, ";

        String createPushTable = "CREATE TABLE IF NOT EXISTS sessions (" +
                "id INTEGER PRIMARY KEY, " +
                "splitDay FOREIGN KEY " +
                "session FOREIGN KEY ";

        String createPuLLTable = "CREATE TABLE IF NOT EXISTS sessions (" +
                "id INTEGER PRIMARY KEY, " +
                "splitDay FOREIGN KEY " +
                "session FOREIGN KEY ";

        String createLegsTable = "CREATE TABLE IF NOT EXISTS sessions (" +
                "id INTEGER PRIMARY KEY, " +
                "splitDay FOREIGN KEY " +
                "session FOREIGN KEY ";




        try (Connection conn = connect()) {
            Statement statement = conn.createStatement();
            statement.execute((createSplitDayTable));
            statement.execute((createPushTable));
            statement.execute((createPuLLTable));
            statement.execute((createLegsTable));
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }
}
