package ru.example.worwebapi.Services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Ingredient;
import ru.example.worwebapi.Services.FilesService;
import ru.example.worwebapi.Services.IngredientService;

import java.util.HashMap;
import java.util.Map;

@Service
public class IngredientImpl implements IngredientService {
    private final FilesService filesService;
    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private Integer generatedIngredientId = 1;
    public IngredientImpl(FilesService filesService) {
        this.filesService = filesService;
    }
    @Override
    public Ingredient createIngredient(Ingredient ingredient) {
        ingredientMap.put(generatedIngredientId, ingredient);
        generatedIngredientId++;
        return ingredient;
    }
    @Override
    public Ingredient getIngredientById() {
        for (Ingredient ingredient : ingredientMap.values()) {
            Ingredient recipes = ingredientMap.get(generatedIngredientId);
            if (recipes != null) {
                return ingredient;
            }
        }
        return null;
    }
@PostConstruct
private void init(){
        readFromFile();
}
    @Override
    public Ingredient updateIngredient(Integer ingredientId, Ingredient ingredient) {
        ingredientMap.put(ingredientId, ingredient);
        return ingredient;
    }

    @Override
    public Ingredient deleteIngredient(IngredientService ingredientId) {
        for (Map<Integer, Ingredient> ingredientMap : ingredientMap.values()) {
            if (ingredientMap.containsKey(ingredientId)) {
                ingredientMap.remove(ingredientId);
            }
        }
        return null;
    }
    @Override
    public void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(ingredientMap);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
    @Override
    public void readFromFile() {
        String json = filesService.readFronFile();
        try {
            ingredientMap = new ObjectMapper().readValue(json, new TypeReference<Map<Integer, Ingredient>>() {
            });
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
