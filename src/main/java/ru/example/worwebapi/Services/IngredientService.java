package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Ingredient;
import ru.example.worwebapi.Services.impl.IngredientImpl;

import java.util.HashMap;
import java.util.Map;


public interface  IngredientService {

    public  Ingredient updateIngredient(Integer ingredientId, Ingredient ingredient);

    public  Ingredient createIngredient(Ingredient ingredient);

    public  Ingredient getIngredientById();

    public  Ingredient deleteIngredient(IngredientService ingredientId);

    void saveToFile();

    void readFromFile();
}






