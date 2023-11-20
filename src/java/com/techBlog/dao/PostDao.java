/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techBlog.dao;

/**
 *
 * @author Swaraj kakade
 */
import com.techBlog.entities.Category;
import com.techBlog.entities.Post;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PostDao {

    private Connection con;

    public PostDao(Connection con) {
        this.con = con;
    }

    public ArrayList<Category> getAllCategories() {
        ArrayList<Category> list = new ArrayList<>();

        try {

            String query = "select * from categories";
            Statement st = this.con.createStatement();
            ResultSet set = st.executeQuery(query);

            while (set.next()) {
                int cid = set.getInt("cid");
                String name = set.getString("name");
                String description = set.getString("description");

                Category c = new Category(cid, name, description);
                list.add(c);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    public boolean savePost(Post post) {
        boolean isSaved = false;
        try {

            String query = "insert into posts(pTitle, pContent, pCode, pPic, catId, hastags, userId) values(?,?,?,?,?,?,?)";
            PreparedStatement pstmt = this.con.prepareStatement(query);

            pstmt.setString(1, post.getpTitle());
            pstmt.setString(2, post.getpContent());
            pstmt.setString(3, post.getpCode());

            if (post.getpPic() == null) {
                pstmt.setString(4, "default.jpeg");
            } else {
                pstmt.setString(4, post.getpPic());
            }

            pstmt.setInt(5, post.getCatId());
            pstmt.setString(6, post.getHastags());
            pstmt.setInt(7, post.getUserId());

            pstmt.executeUpdate();

            isSaved = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return isSaved;
    }

    // Gets all the posts
    public List<Post> getAllPost() {
        List<Post> list = new ArrayList<>();

        // Fetch all posts
        try {

            String query = "select * from posts order by pid desc";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            ResultSet set = pstmt.executeQuery();

            while (set.next()) {
                int pid = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                int catId = set.getInt("catId");
                String hastags = set.getString("hastags");
                int userId = set.getInt("userId");

                Post post = new Post(pid, pTitle, pContent, pCode, pPic, pDate, catId, hastags, userId);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    // Gets posts by category Id
    public List<Post> getPostByCatId(int catId) {
        List<Post> list = new ArrayList<>();

        // Fetch all posts of particular category
        try {

            String query = "select * from posts where catId=?";
            PreparedStatement pstmt = this.con.prepareStatement(query);
            pstmt.setInt(1, catId);
            ResultSet set = pstmt.executeQuery();

            while (set.next()) {
                int pid = set.getInt("pid");
                String pTitle = set.getString("pTitle");
                String pContent = set.getString("pContent");
                String pCode = set.getString("pCode");
                String pPic = set.getString("pPic");
                Timestamp pDate = set.getTimestamp("pDate");
                String hastags = set.getString("hastags");
                int userId = set.getInt("userId");

                Post post = new Post(pid, pTitle, pContent, pCode, pPic, pDate, catId, hastags, userId);

                list.add(post);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }
}
