package ru.example.worwebapi.Services;

import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Recipes;

import java.util.HashMap;
import java.util.Map;

@Service
public
class RecipesService extends Recipes {
    private Map<Long, Recipes> recipesMap = new HashMap<>();
    private Long generatedUserId = 1L;
    @Override
    public Recipes createRecipes(Recipes recipes) {
        recipesMap.put(generatedUserId, recipes);
        generatedUserId++;
        return recipes;
    }
    @Override
    public Recipes getRecipesById(Long recipesId) {
        return recipesMap.get(recipesId);
    }
    @Override
    public Recipes updateRecipes(Long recipesId, Recipes recipes) {
        recipesMap.put(recipesId, recipes);
        return recipes;
    }
    @Override
    public Recipes deleteRecipes(Long recipesId) {
        return recipesMap.remove(recipesId);
    }
    @Override
    public Recipes getCookingTime(Recipes recipes) {
        return recipesMap.get(getCookingTime());
    }
    @Override
    public Recipes getIngredients(Recipes recipes) {
        return recipesMap.get(getIngredients());
    }
    @Override
    public Recipes getCookingSteps(Recipes recipes) {
        return recipesMap.get(getCookingSteps());
            }
    @Override
    public Recipes getName(Recipes recipes) {
        return recipesMap.get(getName());
    }
}