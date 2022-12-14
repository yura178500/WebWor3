package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Recipes;
import ru.example.worwebapi.Services.impl.RecipesImpl;

import java.util.HashMap;
import java.util.Map;

@Service
public abstract class RecipesService {
    public abstract Recipes deleteRecipes(Long recipesId);

    protected abstract void saveToFile();

    protected abstract void readFromFile();

    public abstract Recipes createRecipes(Recipes recipes);

    public abstract Long getRecipesById(Long recipesId);

    public abstract Recipes updateRecipes(Long recipesId, Recipes recipes);
}


