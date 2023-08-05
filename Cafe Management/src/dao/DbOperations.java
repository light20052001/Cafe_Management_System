/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.*;
import java.sql.ResultSet;
//import model. User;

public class DbOperations {

    public static void setDataOrDelete(String Query, String msg) {
        try {
            Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();

            st.executeUpdate(Query);
            if (!msg.equals("")) {
                JOptionPane.showMessageDialog(null, msg);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public static java.sql.ResultSet getData(String query, String... params) {
    try {
        Connection con = ConnectionProvider.getCon();
        PreparedStatement statement = con.prepareStatement(query);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                statement.setString(i + 1, params[i]);
            }
        }
        java.sql.ResultSet myResultSet = statement.executeQuery();
        return myResultSet;
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e, "Message", JOptionPane.ERROR_MESSAGE);
        return null;
    }
}

}
