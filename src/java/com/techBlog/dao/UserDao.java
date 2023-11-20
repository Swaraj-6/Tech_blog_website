/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techBlog.dao;

/**
 *
 * @author Swaraj kakade
 */
import com.techBlog.entities.User;
import java.sql.*;

public class UserDao {

    private Connection con;

    // Constructor
    public UserDao(Connection con) {
        this.con = con;
    }

    // method to insert user to database
    // This function returns three interger values
    // 0 for failed in saving data into database
    // 1 for success in saving data into database
    // 2 for email already existed in database
    public int saveUser(User user) {
        int saved = 0;
        try {
            // Check if the email is already in use
            if (!isEmailAlreadyUsed(user.getEmail())) {
                // If not, insert the new user
                String query = "INSERT INTO user(name, email, password, gender, about) VALUES (?,?,?,?,?)";
                try (PreparedStatement pstmt = this.con.prepareStatement(query)) {
                    pstmt.setString(1, user.getName());
                    pstmt.setString(2, user.getEmail());
                    pstmt.setString(3, user.getPassword());
                    pstmt.setString(4, user.getGender());

                    String aboutValue = (user.getAbout() != null && !user.getAbout().isEmpty()) ? user.getAbout() : "Hey! I am using TechBlog";
                    pstmt.setString(5, aboutValue);

                    pstmt.executeUpdate();
                    saved = 1;
                }
            }else{
                saved = 2;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return saved;
    }


// get user by usermail and password
public User getUserEmailAndPassword(String email, String password) {
        User user = null;

        try {

            String query = "select * from user where email =? and password=?";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, email);
            pstmt.setString(2, password);

            ResultSet set = pstmt.executeQuery();

            if (set.next()) {
                user = new User();

                // Getting data from database
                String name = set.getString("name");
                int id = set.getInt("id");
                String user_email = set.getString("email");
                String user_password = set.getString("password");
                String gender = set.getString("gender");
                String about = set.getString("about");
                String profile = set.getString("profile");
                Timestamp time = set.getTimestamp("rdate");

                // Putting data into user object
                user.setName(name);
                user.setId(id);
                user.setEmail(user_email);
                user.setPassword(user_password);
                user.setGender(gender);
                user.setAbout(about);
                user.setProfile(profile);
                user.setDateTime(time);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }

    public boolean updateUser(User user){
        boolean isUpdate = false;
        try{
            String query = "update user set name=?, email=?, password=?, gender=?, about=?, profile=? where id=?";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setString(1, user.getName());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getGender());
            pstmt.setString(5, user.getAbout());
            pstmt.setString(6, user.getProfile());
            pstmt.setInt(7, user.getId());
            
            pstmt.executeUpdate();
            
            isUpdate = true;
        } catch(Exception e){
            e.printStackTrace();
        }
        return isUpdate;
    }
    
    public String getUserNameById(int id){
        String userName = null;
        try{
            
            String query = "select * from user where id=?";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setInt(1, id);
            
            ResultSet set = pstmt.executeQuery();
            if(set.next()){
                userName = set.getString("name");
            }
            
        } catch (Exception e){
            e.printStackTrace();
        }
        return userName;
    }

    // Check if the email is already in use
    private boolean isEmailAlreadyUsed(String email) throws SQLException {
        String query = "SELECT COUNT(*) FROM user WHERE email=?";
        try (PreparedStatement pstmt = this.con.prepareStatement(query)) {
            pstmt.setString(1, email);
            try (ResultSet resultSet = pstmt.executeQuery()) {
                if (resultSet.next()) {
                    int count = resultSet.getInt(1);
                    return count > 0; // If count is greater than 0, email is already in use
                }
            }
        }
        return false;
    }
    
}
