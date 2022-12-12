package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Ingredient;

import java.util.HashMap;
import java.util.Map;

@Service
public abstract class IngredientService extends Ingredient {
    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private Integer generatedIngredientId = 1;


    @Override
   public Ingredient createIngredient(Ingredient ingredient) {
        ingredientMap. put(generatedIngredientId, ingredient);
        generatedIngredientId++;
        return ingredient;
    }

   @Override
    public Ingredient getIngredientById(Integer ingredientId) {
        return ingredientMap.get(ingredientId);
    }
    @Override
    public Ingredient updateIngredient(Integer ingredientId, Ingredient ingredient) {
        ingredientMap.put(ingredientId, ingredient);
        return ingredient;
    }

    @Override
    public void setIdIngredient(Long idIngredient) {

    }

    @Override
    public void setIdIngredient(Integer idIngredient) {
        setIdIngredient(idIngredient);
    }
    @Override
    public Ingredient deleteIngredient(IngredientService ingredientId) {
        return ingredientMap.remove(ingredientId);
    }
    @Override
    public Ingredient getNameIngredient(Ingredient ingredient) {
       return ingredientMap.get(getNameIngredient());
     }
    @Override
    public Ingredient getNumberIngredients(Ingredient ingredient) {
        return ingredientMap.get(getNameIngredient());
    }
    @Override
    public Ingredient getUnit(Ingredient ingredient) {
        return ingredientMap.get(getUnit());
    }
}
