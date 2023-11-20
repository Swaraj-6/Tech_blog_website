/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techBlog.entities;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author Swaraj kakade
 */
public class Post {
    private int pid;
    private String pTitle;
    private String pContent;
    private String pCode;
    private String pPic;
    private Timestamp pDate;
    private int catId;
    private String hastags;
    private int userId;
    
    // Constructors
    
    public Post(){
        
    }

    public Post(int pid, String pTitle, String pContent, String pCode, String pPic, Timestamp pDate, int catId, String hastags, int userId) {
        this.pid = pid;
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.pDate = pDate;
        this.catId = catId;
        this.hastags = hastags;
        this.userId = userId;
    }
    
    public Post(String pTitle, String pContent, String pCode, String pPic, Timestamp pDate, int catId, String hastags, int userId) {
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.pDate = pDate;
        this.catId = catId;
        this.hastags = hastags;
        this.userId = userId;
    }
    
    public Post(String pTitle, String pContent, String pCode, String pPic, Timestamp pDate, String hastags, int userId) {
        this.pTitle = pTitle;
        this.pContent = pContent;
        this.pCode = pCode;
        this.pPic = pPic;
        this.pDate = pDate;
        this.hastags = hastags;
        this.userId = userId;
    }

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getpTitle() {
        return pTitle;
    }

    public void setpTitle(String pTitle) {
        this.pTitle = pTitle;
    }

    public String getpContent() {
        return pContent;
    }

    public void setpContent(String pContent) {
        this.pContent = pContent;
    }

    public String getpCode() {
        return pCode;
    }

    public void setpCode(String pCode) {
        this.pCode = pCode;
    }

    public String getpPic() {
        return pPic;
    }

    public void setpPic(String pPic) {
        this.pPic = pPic;
    }

    public String getpDate() {
        java.util.Date dateTime = new java.util.Date(this.pDate.getTime());
        
        SimpleDateFormat dateFormat = new SimpleDateFormat("d MMM yyy h:mm a");
        
        String formattedDateTime = dateFormat.format(dateTime);
        return formattedDateTime;
    }

    public void setpDate(Timestamp pDate) {
        this.pDate = pDate;
    }

    public int getCatId() {
        return catId;
    }

    public void setCatId(int catId) {
        this.catId = catId;
    }

    public String getHastags() {
        return hastags;
    }

    public void setHastags(String hastags) {
        this.hastags = hastags;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    
    
}
