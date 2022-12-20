package ru.example.worwebapi.Services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Ingredient;
import ru.example.worwebapi.Services.FilesService;
import ru.example.worwebapi.Services.IngredientService;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class IngredientImpl implements IngredientService {
    private final FilesService filesService;
    private Map<Integer, Ingredient> ingredientMap = new HashMap<>();
    private Integer generatedIngredientId = 1;

    public IngredientImpl(FilesService filesService) {
        this.filesService = filesService;
    }

    private final Map<Long, Ingredient> ingredientsStorage = new HashMap<>(Map.of(
            1L, new Ingredient("Куриное яйцо", 2, "штуки"),
            2L, new Ingredient("Пшеничная мука", 6, "столовых ложек"),
            3L, new Ingredient("Сахар", 2, "столовые ложки")));

    @Override
    public Ingredient getIngredientById(Long ingredientId) {
        return ingredientsStorage.get(ingredientId);
    }

    @Override
    public Map<Long, Ingredient> getAllIngredients() {
        return ingredientsStorage;
    }

    @Override
    public void addIngredient(Ingredient ingredient) {
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
    private void init() {
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

    @Override
    public Path createMonthReport(Month month) throws IOException {
        LinkedHashMap<Integer, Ingredient> monthTransact = ingredientMap.getOrDefault(month, new LinkedHashMap<>());
        Path path = filesService.createTempFile("monthReport");
        for (Ingredient ingredient : monthTransact.values()) ;
        try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)) {
            writer.append(ingredientMap.getClass() + ":" + ingredientMap.get(toString()));
            writer.append("\n");

        }
        return path;
    }

    @Override
    public void addIngredientFromInputStream(InputStream inputStream) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream)) {
            String line = reader.readLine();

            {
                while (line != null) {
                    String[] array = StringUtils.split(line, "|");
                    Ingredient ingredient = new Ingredient(String.valueOf(array[0]), Integer.valueOf(array[1]), array[2]);
                    createIngredient(ingredient);
                }
            }
        }
    }
}

