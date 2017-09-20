<%-- 
    Document   : chrrecipe
    Created on : Sep 20, 2017, 8:20:09 AM
    Author     : Christian
--%>

<%@page import="Entities.Ingredient"%>
<%@page import="java.util.ArrayList"%>
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
        RecipeMapper rm = null;
        String myString = "Der er en fejl!";
        Recipe myRecipe = null;
        try {   
            rm = new RecipeMapper();
            myRecipe = rm.getRecipe(rm.getRecipeId(myvalue));
            myString = myRecipe.toString();
        } catch (Exception e) {
            out.print("Der er ingen forbindelse til serveren");
        }
        %>
        <%= myString%>
        
        <%
        int findId = 0;
        String findName = "";
        String findInstr = "";
        String stringifyIngre = "";
        ArrayList<Ingredient> findIngre = null;
        if (myRecipe != null) {
            findName = myRecipe.getName();
            findId = rm.getRecipeId(findName);
            findInstr = myRecipe.getInstruction();
            findIngre = myRecipe.getIngredientList();
            
            stringifyIngre = "";
            for (Ingredient i: findIngre) {
                stringifyIngre = stringifyIngre +
                        i.toString() + "\n";
            }
            
        }
        %>
        
        <form action="UpdateRecipeServlet">  
            <input type="hidden" name="id" value=<%=findId%> >
            <b>Recipe name:</b><br>
            <input type="text" name="recname" value=<%=findName%>    ><br><br>
            <b>Ingredients:</b><br>
            (Seperate ingredients with <b>;</b> )<br>
            <textarea name="ingredients" rows="10" cols="40"><%= stringifyIngre          
            %></textarea><br><br>
            <b>Instructions:</b><br>
            <textarea name="description" rows="10" cols="40"  ><%=findInstr%>  </textarea><br><br>
            <b>Image URL:</b><br>
            <input type="text" name="imagelink" value="http://"><br><br>
            <input type="submit" name="submit" value="Update">
        </form>
              
        
        <br>
        <a href="<%="showrecipes.jsp"%>"><%="Gå til showrecipes"%></a>
    </body>
</html>
