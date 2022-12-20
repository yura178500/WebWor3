package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Recipes;
import ru.example.worwebapi.Services.impl.RecipesImpl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;


public interface RecipesService {
    void addRecipesFromInputStream(InputStream inputStream) throws IOException;

    public Recipes deleteRecipes(Long recipesId);

    void saveToFile();

    void readFromFile();

    public Recipes createRecipes(Recipes recipes);

    public Long getRecipesById(Long recipesId);

    public Recipes updateRecipes(Long recipesId, Recipes recipes);

    Path createMonthReport(Month month) throws IOException;
}


