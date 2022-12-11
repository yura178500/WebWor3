package ru.example.worwebapi.Services.impl;


import ru.example.worwebapi.Model.Recipes;

public abstract class RecipesImpl extends Recipes {

    public RecipesImpl(String name, int cookingTime, String ingredients, String cookingSteps, Long id) {
        super(name, cookingTime, ingredients, cookingSteps, id);
    }

    public String getName() {
        return null;
    }

    public int getCookingTime() {
        return 0;
    }
    public String getIngredients() {
        return null;
    }

    public String getCookingSteps() {
        return null;
    }

}
