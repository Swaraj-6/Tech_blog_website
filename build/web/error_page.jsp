<%-- 
    Document   : error_page
    Created on : 05-Nov-2023, 5:36:51 pm
    Author     : Swaraj kakade
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page isErrorPage="true" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sorry! something went wrong...</title>
        
        <!--CSS-->
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">     
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
        <link href="css/mystyle.css" rel="stylesheet" type="text/css"/>
        
        <style>
            .banner-background{
             clip-path: polygon(30% 0%, 70% 0%, 100% 0, 100% 91%, 63% 100%, 22% 91%, 0 99%, 0 0);
            }
        </style> 
    </head>
    <body>
        <div class="container text-center">
            <img src="img/error_img.png" class="img-fluid" >
            <h3 class="display-3">Sorry ! Something went wrong ...</h3>
            <%= exception %>
            <a href="index.jsp" class="btn secondary-background btn-lg text-white mt-3">Home </a>
        </div>
        
       
    </body>
</html>
