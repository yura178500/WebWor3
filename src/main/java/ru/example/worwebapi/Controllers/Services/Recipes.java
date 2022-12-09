package ru.example.worwebapi.Controllers.Services;

import java.util.HashMap;
import java.util.Map;

public interface Recipes {
    String getName();

    int getCookingTime();

    String getIngredients();

    String getCookingSteps();

    Map<Long, Recipes> recipes = new HashMap<>();
    Long getRecipesId = 1L;

    public static Recipes createRecipes(Recipes recipes) {
        recipes.put(getRecipesId, recipes);
        return recipes;
    }
    void put(Long generatedRecipesId, Recipes recipes);

    public static Recipes getRecipesId(Long recipesId) {
        return recipes.get(recipesId);
    }

    public static Recipes updateRecipes(Long recipesId, Recipes recipes) {
        Recipes.recipes.put(recipesId, (Recipes) Recipes.recipes);
        return recipes;
    }

    public static Recipes deleteRecipes(Long recipesId) {
        return recipes.remove(recipesId);
    }

    Long getId();
}
