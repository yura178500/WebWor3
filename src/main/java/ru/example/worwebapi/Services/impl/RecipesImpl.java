package ru.example.worwebapi.Services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Recipes;
import ru.example.worwebapi.Services.FilesService;
import ru.example.worwebapi.Services.RecipesService;

import java.util.HashMap;
import java.util.Map;

@Service
public final class RecipesImpl extends RecipesService {
    final private FilesService filesService;
    private Long recipesId;
    private Recipes recipes;

    public RecipesImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    private Map<Long, Recipes> recipesMap = new HashMap<>();
    private Long generatedUserId = 1L;

    @Override
    public Recipes deleteRecipes(Long recipesId) {
        for (Map<Long, Recipes> recipesMap : recipesMap.values()) {
            if (recipesMap.containsKey(recipesId)) {
                recipesMap.remove(recipesId);
            }
        }
        return null;
    }

    @Override
    protected void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipesMap);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    protected void readFromFile() {
        String json = filesService.readFronFile();
        try {
            recipesMap = new ObjectMapper().readValue(json, new TypeReference<Map<Long, Recipes>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }

    @Override
    public Recipes createRecipes(Recipes recipes) {
        recipesMap.put(generatedUserId, recipes);
        generatedUserId++;
        saveToFile();
        return recipes;


    }

    @Override
    public Long getRecipesById(Long recipesId) {
        for (Recipes recipesMap : recipesMap.values()) {
            Long recipes = recipesMap.getRecipesId();
            if (recipes != null) {
                return recipes;
            }
            saveToFile();
        }
        return null;

    }

    @Override
    public Recipes updateRecipes(Long recipesId, Recipes recipes) {
        this.recipesId = recipesId;
        this.recipes = recipes;
        recipesMap.put(recipesId, recipes);
        saveToFile();
        return recipes;
    }

}
