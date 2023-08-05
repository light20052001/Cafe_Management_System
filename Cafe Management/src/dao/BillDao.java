/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Bill;

/**
 *
 * @author LENOVO
 */
public class BillDao {

    public static String getId() {
        int id = 1;
        try {
            //ResultSet rs = DbOperations.getData("select max(id) from bill");
            java.sql.ResultSet myResultSet = (java.sql.ResultSet) DbOperations.getData("select max(id) from bill");
            if (myResultSet.next()) {
                id = myResultSet.getInt(1);
                id = id + 1;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return String.valueOf(id);
    }

    public static void save(Bill bill) {
        String query = "insert into bill value('" + bill.getId() + "','" + bill.getName() + "','" + bill.getMobileNumber() + "','" + bill.getEmail() + "','" + bill.getDate() + "','" + bill.getTotal() + "','" + bill.getCreatedBy() + "')";
        DbOperations.setDataOrDelete(query, "Bill details added Successfully.");

    }
    public static ArrayList<Bill> getAllRecordsByInc(String date) {
    ArrayList<Bill> arrayList = new ArrayList<>();

    try {
          java.sql.ResultSet myResultSet = (java.sql.ResultSet)DbOperations.getData("SELECT * FROM bill WHERE date LIKE '%" + date + "%'");
        while (myResultSet.next()) {
            Bill bill = new Bill();
            bill.setId(myResultSet.getInt("id"));
            bill.setName(myResultSet.getString("name"));
            bill.setMobileNumber(myResultSet.getString("mobileNumber"));
            bill.setEmail(myResultSet.getString("email"));
            bill.setDate(myResultSet.getString("date"));
            bill.setTotal(myResultSet.getString("total"));
            bill.setCreatedBy(myResultSet.getString("createdBy"));
            arrayList.add(bill);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
}
    public static ArrayList<Bill> getAllRecordsByDesc(String date) {
    ArrayList<Bill> arrayList = new ArrayList<>();

    try {
          java.sql.ResultSet myResultSet = (java.sql.ResultSet)DbOperations.getData("SELECT * FROM bill WHERE date LIKE '%" + date + "%' order By id DESC");
        while (myResultSet.next()) {
            Bill bill = new Bill();
            bill.setId(myResultSet.getInt("id"));
            bill.setName(myResultSet.getString("name"));
            bill.setMobileNumber(myResultSet.getString("mobileNumber"));
            bill.setEmail(myResultSet.getString("email"));
            bill.setDate(myResultSet.getString("date"));
            bill.setTotal(myResultSet.getString("total"));
            bill.setCreatedBy(myResultSet.getString("createdBy"));
            arrayList.add(bill);
        }
    } catch (Exception e) {
        JOptionPane.showMessageDialog(null, e);
    }
    return arrayList;
}

}
    