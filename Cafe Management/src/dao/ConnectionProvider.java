/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package dao;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author LENOVO
 */
//public class ConnectionProvider {
//    public static Connection getCon(){
//        try{
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?allowPublicKeyRetrieval=true","root","Amibes1234@");
//    
//        return con;
//        }
//        catch(Exception e){
//            return null;
//        }
//    }
//}

public class ConnectionProvider {
    public static Connection getCon() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms?allowPublicKeyRetrieval=true","root","Amibes1234@");
        return con;
    }
}




    

