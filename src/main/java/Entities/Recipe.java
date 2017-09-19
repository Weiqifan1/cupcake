/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;

import java.util.ArrayList;

/**
 *
 * @author GertLehmann
 */
public class Recipe {

    private final String name;
    private final ArrayList<Ingredient> ingredientList;
    private final String instruction;
    private final String imageUrl;

    public Recipe(String name, ArrayList<Ingredient> ingredientList, String instruction, String imageUrl) {
        this.name = name;
        this.ingredientList = ingredientList;
        this.instruction = instruction;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public String getInstruction() {
        return instruction;
    }

    public String getImageUrl() {
        return imageUrl;
    }
    
    

    @Override
    public String toString() {
        String out;
        out =  "Name=" + name;
        for (Ingredient i : ingredientList) {
            out += i.toString();
        }
        out += "<br>Instructions=" + instruction;
        out += "<br>Image URL=" + imageUrl;
        return out;
    }
    
    
    
}
