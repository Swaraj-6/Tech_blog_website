/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.techBlog.helper;

import java.util.Random;

/**
 *
 * @author Swaraj kakade
 */
public class FileNameGenerator {
    
    public static String generateUniqueFileName(String originalFileName){
        
        String fileExtension = originalFileName.substring(originalFileName.lastIndexOf("."));
        String uniqueFileName = generateUniqueName(10) + fileExtension ;
        
        return uniqueFileName;
    }
    
    
    private static String generateUniqueName(int length){
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder newName = new StringBuilder();
        
        Random random = new Random();
        
        for(int i=0; i<length; i++){
            int randomIndex = random.nextInt(characters.length());
            
            newName.append(characters.charAt(randomIndex));
        }
        
        return newName.toString();
    }
}
