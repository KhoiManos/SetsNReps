package io.github.khoimanos;

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

    public static void domainExpansionTABLES() {
        String createPushTable = "CREATE TABLE IF NOT EXISTS push_sessions (" +
                "id INTEGER PRIMARY KEY, " +
                "chestflys REAL, " +
                "bench REAL, " +
                "triceps REAL, " +
                "lateralRaises REAL)";

        String createPullTable = "CREATE TABLE IF NOT EXISTS pull_sessions (" +
                "id INTEGER PRIMARY KEY, " +
                "musclePullUps REAL, " +
                "preacherCurls REAL, " +
                "cableRow REAL, " +
                "reverseCurls REAL)";

        String createLegsTable = "CREATE TABLE IF NOT EXISTS legs_sessions (" +
                "id INTEGER PRIMARY KEY, " +
                "squats REAL, " +
                "legCurl REAL, " +
                "legExtensions REAL, " +
                "calfRaise REAL)";

        try (Connection conn = connect()) {
            Statement statement = conn.createStatement();
            statement.execute(createPushTable);
            statement.execute(createPullTable);
            statement.execute(createLegsTable);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
