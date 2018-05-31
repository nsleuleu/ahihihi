/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo.model;
import demo.entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *
 * @author namdeptrai
 */
public class UserModel {
    public boolean register(User user) {
        try {
            Connection cnn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement("insert into `users` (`username`, `password`, `email`) values (?,?,?)");
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            ps.execute();
            return true;
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public boolean checkExistUsername(String username) {
        try {
            Connection cnn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement("select * from `users` where username = ?");
            ps.setString(1, username);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return true;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return false;
    }

    public User login(String username, String password) {
        try {
            Connection cnn = DBConnection.getInstance().getConnection();
            PreparedStatement ps = cnn.prepareStatement("select * from `users` where username = ? and password = ?");
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("id");
                String strUsername = rs.getString("username");
                String strPassword = rs.getString("password");
                String email = rs.getString("email");
                String createdDate = rs.getString("createdDate");
                User user = new User(id, strUsername, strPassword, email, createdDate);
                return user;
            }
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }        
        return null;
    }
}
