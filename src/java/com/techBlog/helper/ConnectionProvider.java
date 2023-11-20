/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techBlog.helper;

/**
 *
 * @author Swaraj kakade
 */
import java.sql.*;

public class ConnectionProvider {

    private static Connection con;

    public static Connection getConnection() {
        try {

            if (con == null) {
                // Driver class load
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Create a connection
                String url = "jdbc:mysql://localhost:3306/techblogs";
                String user = "root";
                String pass = "swaraj123";
                con = DriverManager.getConnection(url, user, pass);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;

    }

}
