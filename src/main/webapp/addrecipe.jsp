<%-- 
    Document   : addrecipe
    Created on : Sep 17, 2017, 8:23:33 PM
    Author     : Christian
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Addrecipe</h1>

        <form action="AddRecipeServlet">       
            <h2>Add New Recipe:</h2>

            <b>Recipe name:</b><br>
            <input type="text" name="recname" value=""><br><br>
            <b>Ingredients:</b><br>
            <textarea name="ingridient" rows="10" cols="40"></textarea><br><br>
            <b>Instructions:</b><br>
            <textarea name="instuction" rows="10" cols="40"></textarea><br><br>
            <input type="submit" name="submit" value="Add">
        </form>


    </body>
</html>
