package ru.example.worwebapi.Services;
import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Recipes;

import java.util.HashMap;
import java.util.Map;
@Service
public
class RecipesService {
    private Map<Long, Recipes> recipesMap = new HashMap<>();
    private Long generatedUserId = 1L;

    public Recipes createRecipes(Recipes recipes) {
        recipesMap. put(generatedUserId, recipes);
        generatedUserId++;
        return recipes;
    }

    public Recipes getRecipesById(Long recipesId) {
        return recipesMap.get(recipesId);
    }

    public Recipes updateRecipes(Long recipesId, Recipes recipes) {
        recipesMap.put(recipesId, recipes);
        return recipes;
    }


    public Recipes deleteRecipes(Long recipesId) {
        return recipesMap.remove(recipesId);
    }
}