/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import Entities.Ingredient;
import Entities.Recipe;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author GertLehmann
 */
public class RecipeMapper {

    public List<String> getAllRecipeNames() throws SQLException { //return list of strings
        String sql = "SELECT name FROM opskrift.recipes";
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        List<String> names = new ArrayList();
        while (rs.next()) {
            String recipeName = rs.getString("name");
            names.add(recipeName);
        }
        return names;
    }

    public int getRecipeId(String name) throws SQLException { //return list of strings
        int recipeId = 0;
        String sql = "select recipe_id from recipes where name='"+name+"'";
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            recipeId = rs.getInt("recipes.recipe_id");
        }
        return recipeId;
    }

    
    
    public Recipe getRecipe(int id) throws SQLException { //return list of strings
        Recipe out = null;
        String sql = "SELECT name,ingredients, instructions,image_url FROM opskrift.recipes where recipe_id=" + id;
        PreparedStatement pstmt = Connector.getConnection().prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            String recipeName = rs.getString("name");
            String recipeInstruction = rs.getString("instructions");
            String recipeImage = rs.getString("image_url");

            String ingredientList = rs.getString("ingredients");
            ArrayList<Ingredient> recipeIngredients = new ArrayList();
            String[] iList = ingredientList.split(";");
            for (String s : iList) {
                recipeIngredients.add(new Ingredient(s));
            }
            
            out = new Recipe(recipeName,recipeIngredients, recipeInstruction, recipeImage);
        }
        return out;
    }

    public static void main(String[] args) throws SQLException {
        List<String> names = new RecipeMapper().getAllRecipeNames();
        for (String name : names) {
            System.out.println(name);
        }
        
        Recipe test = new RecipeMapper().getRecipe(1);
        System.out.println(test);
        
        int testId = new RecipeMapper().getRecipeId("lagkage");
        System.out.println(testId);
        
    }

}
