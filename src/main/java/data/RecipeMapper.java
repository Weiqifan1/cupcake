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
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

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
  public void putRecipe(Recipe recipe) throws SQLException { //return list of strings
             
        String insertRecipe = "insert into recipes (name, ingredients, instructions, image_url) values (?, ?, ?, ?)";
        PreparedStatement recipePstmt = Connector.getConnection().prepareStatement(insertRecipe);
        
        recipePstmt.setString(1, recipe.getName());
        
        ArrayList<Ingredient> ingredientsList = recipe.getIngredientList();
        String ingredients = "";
        for (Ingredient ing : ingredientsList) {
            ingredients += ing.getIngredient()+";";
        }
        int len = ingredients.length();
        ingredients = ingredients.substring(0,len-1);
        
        recipePstmt.setString(2, ingredients);
        recipePstmt.setString(3, recipe.getInstruction());
        recipePstmt.setString(4, recipe.getImageUrl());
        
        recipePstmt.executeUpdate();
        
  }

    public static void main(String[] args) throws SQLException {
        
//        List<String> names = new RecipeMapper().getAllRecipeNames();
//        for (String name : names) {
//            System.out.println(name);
//        }
//        
//        Recipe testGetOnId = new RecipeMapper().getRecipe(1);
//        System.out.println(testGetOnId);
//        
//        int testFindId = new RecipeMapper().getRecipeId("lagkage");
//        System.out.println(testFindId);
//        
//        ArrayList<Ingredient> testIngredients = new ArrayList();
//        testIngredients.add(new Ingredient("100g marcipan"));
//        testIngredients.add(new Ingredient("50g mel"));
//        testIngredients.add(new Ingredient("25g chokolade"));
//        Recipe testPut = new Recipe("Napoleonshat",testIngredients,"Form det som en hat","http://france.fr");
//        
//        RecipeMapper Putter = new RecipeMapper();
//        Putter.putRecipe(testPut);
    
    }

}
