package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientService {
    private Map<Long, Ingredient> ingredientMap = new HashMap<>();
    private Long generatedUserId = 1L;
    public Ingredient createIngredient(Ingredient ingredient) {
        ingredientMap. put(generatedUserId, ingredient);
        generatedUserId++;
        return ingredient;
    }
    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientMap.get(ingredientId);
    }

    public Ingredient updateIngredient(Long ingredientId, Ingredient ingredient) {
        ingredientMap.put(ingredientId, ingredient);
        return ingredient;
    }


    public Ingredient deleteIngredient(IngredientService ingredientId) {
        return ingredientMap.remove(ingredientId);
    }
}
