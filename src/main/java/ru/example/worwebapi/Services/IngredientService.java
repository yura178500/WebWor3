package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Ingredient;
import ru.example.worwebapi.Services.impl.IngredientImpl;

import java.util.HashMap;
import java.util.Map;

@Service
public abstract class IngredientService {

    public abstract Ingredient updateIngredient(Integer ingredientId, Ingredient ingredient);

    public abstract Ingredient createIngredient(Ingredient ingredient);

    public abstract Ingredient getIngredientById();

    public abstract Ingredient deleteIngredient(IngredientService ingredientId);

    protected abstract void saveToFile();

    protected abstract void readFromFile();
}




