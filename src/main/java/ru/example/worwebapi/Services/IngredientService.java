package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Ingredient;
import ru.example.worwebapi.Services.impl.IngredientImpl;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.time.Month;
import java.util.HashMap;
import java.util.Map;


public interface IngredientService {

    public Ingredient updateIngredient(Integer ingredientId, Ingredient ingredient);

    Ingredient getIngredientById(Long ingredientId);

    Map<Long, Ingredient> getAllIngredients();

    void addIngredient(Ingredient ingredient);

    public Ingredient createIngredient(Ingredient ingredient);

    public Ingredient getIngredientById();

    public Ingredient deleteIngredient(IngredientService ingredientId);

    void saveToFile();

    void readFromFile();

    Path createMonthReport(Month month) throws IOException;

    void addIngredientFromInputStream(InputStream inputStream) throws IOException;
}






