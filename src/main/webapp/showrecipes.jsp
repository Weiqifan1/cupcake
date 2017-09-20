<%-- 
    Document   : showrecipes
    Created on : Sep 19, 2017, 10:39:46 PM
    Author     : Christian
--%>

<%@page import="java.util.Collections"%>
<%@page import="java.util.List"%>
<%@ page import="data.RecipeMapper" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello Customer!</h1>
        <br>
        <p>Here are the recipes:</p>
        <br>
        <%
        String output = "";
        try {        
            RecipeMapper rm = new RecipeMapper();
            List<String> mylist = rm.getAllRecipeNames();
            Collections.sort(mylist, String.CASE_INSENSITIVE_ORDER);
            output = output+"<p>";
            for (String s: mylist) {
                    out.println( "<a href =" + "showrecipe.jsp" +
                            "?value="+ s +
                            "> " + s + "</a>"
                            + "<br>");
            }
        } catch (Exception e) {
            out.print("Der er ingen forbindelse til serveren");
        }
        %>    
              
        
        
    </body>
    <br>
    <a href="<%="addrecipe.jsp"%>"><%="Gå til addrecipe"%></a>
    
</html>
