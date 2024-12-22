package com.foodApp.daoImpl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.foodApp.model.Item;

public class ItemDAOImpl {
    private Connection con;

    public ItemDAOImpl() {
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/fooddelivery", "root", "root");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Item> searchItems(String query) {
        List<Item> items = new ArrayList<>();
        String sql = "SELECT * FROM items WHERE name LIKE ? OR description LIKE ?";
        
        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
            pstmt.setString(1, "%" + query + "%");
            pstmt.setString(2, "%" + query + "%");
            
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Item item = new Item(
                    rs.getInt("id"),
                    rs.getString("name"),
                    rs.getString("description"),
                    rs.getDouble("price")
                );
                items.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return items;
    }
}
