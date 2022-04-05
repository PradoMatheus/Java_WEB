package br.com.fatec.web.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Connect {

    public static Connection getConnection() {
        try {
            String server = "localhost";
            String user = "postgres";
            String password = "123456";
            String database = "web";

            Class.forName("org.postgresql.Drive");

            return DriverManager.getConnection(
                    "jdbc:postgresql://" + server + "/" + database,
                    user,
                    password);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static void close(Connection conn) {
        if (conn != null) {
            try {
                conn.close();
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
