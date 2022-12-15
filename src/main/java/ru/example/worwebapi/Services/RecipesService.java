package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Recipes;
import ru.example.worwebapi.Services.impl.RecipesImpl;

import java.util.HashMap;
import java.util.Map;


public interface  RecipesService {
    public  Recipes deleteRecipes(Long recipesId);

    void saveToFile();

    void readFromFile();

    public  Recipes createRecipes(Recipes recipes);

    public  Long getRecipesById(Long recipesId);

    public  Recipes updateRecipes(Long recipesId, Recipes recipes);
}


