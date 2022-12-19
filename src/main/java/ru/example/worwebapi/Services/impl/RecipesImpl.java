package ru.example.worwebapi.Services.impl;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;
import ru.example.worwebapi.Model.Recipes;
import ru.example.worwebapi.Services.FilesService;
import ru.example.worwebapi.Services.RecipesService;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.time.Month;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Service
public final class RecipesImpl implements RecipesService {
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
    public void saveToFile() {
        try {
            String json = new ObjectMapper().writeValueAsString(recipesMap);
            filesService.saveToFile(json);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }

    @PostConstruct
    private void init1(){
        readFromFile();
    }

    @Override
    public void readFromFile() {
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
@Override
    public Path createMonthReport(Month month) throws IOException {
        LinkedHashMap<Long, Recipes> monthTransact = recipesMap.getOrDefault(month, new LinkedHashMap<>());
        Path path = filesService.createTempFile("monthReport");
        for (Recipes recipesMap: monthTransact.values());
        try (Writer writer = Files.newBufferedWriter(path, StandardOpenOption.APPEND)){
            writer.append(recipesMap.getClass() + ":" + recipesMap.get(toString()));
            writer.append("\n");

        }return path;
    }
}





