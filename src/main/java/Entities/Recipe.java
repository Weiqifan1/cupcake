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
    private final String instructions;

    public Recipe(String name, ArrayList<Ingredient> ingredientList, String instructions) {
        this.name = name;
        this.ingredientList = ingredientList;
        this.instructions = instructions;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public String getInstructions() {
        return instructions;
    }
    
    
    
}
