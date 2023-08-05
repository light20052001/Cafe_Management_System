/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model. User;


public class UserDao {

    public static void save(User user) {
        String query = "insert into user(name, email, mobileNumber, address, password, securityQuestion, answer, status) values('" + user.getName() + "','" + user.getEmail() + "','" + user.getMobileNumber() + "','"
                + user.getAddress() + "','" + user.getPassword() + "','" + user.getSecurityQuestion() + "','"
                + user.getAnswer() + "','false')";
            DbOperations.setDataOrDelete(query, "Registered Successfully! Wait for Admin Approval!");
    }


    public static User login(String email, String password) {
    User user = null;
    try {
        
        java.sql.ResultSet myResultSet = (java.sql.ResultSet)DbOperations.getData("SELECT * FROM user WHERE email = ? AND password = ?", email, password);

        if (myResultSet.next()) {
            user = new User();
            user.setStatus(myResultSet.getString("status"));
        }
        
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    
    return user;
}

    public static User getSecurityQuestion(String email) throws SQLException {
    User user = null;
    java.sql.ResultSet myResultSet = (java.sql.ResultSet) DbOperations.getData("SELECT * FROM user WHERE email = ?", email);

    if (myResultSet.next()) {
        user = new User();
        user.setSecurityQuestion(myResultSet.getString("securityQuestion"));
        user.setAnswer(myResultSet.getString("answer"));
    }
    return user;
}

    public static void update(String email,String newPassword) throws Exception{
        String query = "Update user set password =  '"+newPassword+"' where email= '"+email+"'";
        DbOperations.setDataOrDelete(query, "Password changed Successfully.");
    }
    
    public static ArrayList<User> getAllRecords (String email) {
        ArrayList<User> arrayList = new ArrayList<>();
        try{
            java.sql.ResultSet myResultSet = (java.sql.ResultSet)DbOperations.getData("select *from user where email like '%"+email+"%'");
            while (myResultSet.next()) {
                User user = new User();
                user.setId(myResultSet.getInt("id"));
                user.setName (myResultSet.getString("name"));
                user.setEmail (myResultSet.getString("email"));
                user.setMobileNumber (myResultSet.getString("mobileNumber"));
                user.setAddress (myResultSet.getString("address"));
                user.setSecurityQuestion (myResultSet.getString("securityQuestion"));
                user.setStatus (myResultSet.getString("status"));
                arrayList.add(user);
            }
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
        return arrayList;
    }
    public static void changeStatus(String email, String status){
        String query = "update user set status='"+status+"'where email ='"+email+"'";
        DbOperations.setDataOrDelete(query,"Status changed Successfully.");
    }
    
    public static void changePassword(String email, String oldPassword, String newPassword){
        try{
            java.sql.ResultSet myResultSet = (java.sql.ResultSet)DbOperations.getData("select *from user where email='"+email+"' and password='"+oldPassword+"'");
            if(myResultSet.next()){
                update(email,newPassword);
            }
            else{
                JOptionPane.showMessageDialog(null,"Old Password is wrong.");
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    public static void changeSecurityQuestion(String email, String password, String securityQuestion, String answer){
        try{
            
            java.sql.ResultSet myResultSet = (java.sql.ResultSet)DbOperations.getData("select * from user where email = ? and password = ?", email, password);
            if(myResultSet.next()){
                 update(email, securityQuestion, answer);
            }
                else{
                        JOptionPane.showMessageDialog(null, "Password is wrong.");               
        }
      }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
    }
    public static void update(String email, String securityQuestion, String answer){
        String query = "update user set securityQuestion='"+securityQuestion+"',answer='"+answer+"'where email='"+email+"'";
        DbOperations.setDataOrDelete(query, "Security Question Changed Successfully.");
    }
    
}



