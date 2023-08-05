/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import static javax.swing.UIManager.getString;
import model.Product;

/**
 *
 * @author LENOVO
 */
public class ProductDao {
    
    public static void save(Product product) {
        String query = "insert into product(name,category,price) values('" + product.getName() + "','" + product.getCategory() + "','" + product.getPrice() + "')";
        DbOperations.setDataOrDelete(query, "Product added Successfully.");
    }

    public static ArrayList<Product> getAllRecords() {
        ArrayList<Product> arrayList = new ArrayList<>();
        
        try {
            java.sql.ResultSet myResultSet = (java.sql.ResultSet) DbOperations.getData("select * from product");
            
            if (myResultSet.next()) {
                do {
                    Product product = new Product();
                    product.setId(myResultSet.getInt("id"));
                    product.setName(myResultSet.getString("name"));
                    product.setCategory(myResultSet.getString("category"));
                    product.setPrice(myResultSet.getString("price"));
                    arrayList.add(product);
                } while (myResultSet.next());
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        
        return arrayList;
    }

    public static void update(Product product) {
        String query = "update product set name = '" + product.getName() + "',category = '" + product.getCategory() + "',price = '" + product.getPrice() + "' where id='" + product.getId() + "'";
        DbOperations.setDataOrDelete(query, "Product Updated Successfully.");
    }

    public static void delete(String id) {
        String query = "delete from product where id= '" + id + "'";
        DbOperations.setDataOrDelete(query, "Product Deleted Successfully.");
    }
    
    public static ArrayList<Product> getAllRecordsByCategory(String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            java.sql.ResultSet myResultSet = (java.sql.ResultSet) DbOperations.getData("select *from product where category='" + category + "'");
            while (myResultSet.next()) {
                Product product = new Product();
                product.setName(myResultSet.getString("name"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static ArrayList<Product> filterProductByname(String name, String category) {
        ArrayList<Product> arrayList = new ArrayList<>();
        try {
            java.sql.ResultSet myResultSet = (java.sql.ResultSet) DbOperations.getData("select *from product where name like '%" + name + "%' and category ='" + category + "'");
            while (myResultSet.next()) {
                Product product = new Product();
                product.setName(myResultSet.getString("name"));
                arrayList.add(product);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return arrayList;
    }

    public static Product getProductByname(String name) {
        Product product = new Product();
        try {
            java.sql.ResultSet myResultSet = (java.sql.ResultSet) DbOperations.getData("select *from product where name ='" + name + "'");
            while (myResultSet.next()) {
                product.setName(myResultSet.getString(2));
                product.setCategory(myResultSet.getString(3));
                product.setPrice(myResultSet.getString(4));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return product;
    }
}
