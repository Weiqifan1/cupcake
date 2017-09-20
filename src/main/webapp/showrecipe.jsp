<%-- 
    Document   : chrrecipe
    Created on : Sep 20, 2017, 8:20:09 AM
    Author     : Christian
--%>

<%@page import="Entities.Recipe"%>
<%@page import="data.RecipeMapper"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World! her er chrrecipe.jsp, prof of concept:</h1>
        <%
            String myvalue = request.getParameter("value");
        %>   
        <%= myvalue%>
        <br>
        <br>
        <%
        String myString = "Der er en fejl!";
        try {   
            RecipeMapper rm = new RecipeMapper();
            Recipe myRecipe = rm.getRecipe(rm.getRecipeId(myvalue));
            myString = myRecipe.toString();
        } catch (Exception e) {
            out.print("Der er ingen forbindelse til serveren");
        }
        %>
        <%= myString%>
        
        <br>
        <a href="<%="showrecipes.jsp"%>"><%="Gå til showrecipes"%></a>
    </body>
</html>
