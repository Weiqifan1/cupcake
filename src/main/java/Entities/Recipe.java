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

    public Recipe(String name, ArrayList<Ingredient> ingredientList, String instruction) {
        this.name = name;
        this.ingredientList = ingredientList;
        this.instruction = instruction;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Ingredient> getIngredientList() {
        return ingredientList;
    }

    public String getInstructions() {
        return instruction;
    }

    @Override
    public String toString() {
        String out;
        out =  "Name=" + name;
        for (Ingredient i : ingredientList) {
            out += i.toString();
        }
        out += "<br>Instructions=" + instruction;
        return out;
    }
    
    
    
}
