package org.example;

import javax.swing.*;
import javax.swing.plaf.nimbus.State;
import java.sql.*;

// Java database connectivity theory by telusko

/*
* 1a.   Import connector -> mysql-connector-java
* 1b.   Import sql library -> java.sql.*
* 2.    Load and register the driver -> com.mysql.jdbc.Driver
* 3.    Create connection -> Connection
* 4.    Create statement -> Statement
* 5.    Execute query
* 6.    Process result
* 7.    Close connection
*/

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/testdb";
        String username = "root";
        String password = "newpassword";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");  // step 2 | returns the class definition/instance
        } catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        try {

            Connection con  = DriverManager.getConnection(url, username, password);  // step 3 | establish the connection
            Statement st = con.createStatement();     // step 4 | create statement

            String query = "SELECT * FROM student";

            ResultSet rs = st.executeQuery(query);      // step 5 | execute query
            while(rs.next()) {
                System.out.println(rs.getInt("id") + "  " + rs.getString("name"));
            }
            st.close();     // step 6 | close the statement
            con.close();    // step 7 | close the connection

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}