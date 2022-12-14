package ru.example.worwebapi.Controllers;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.example.worwebapi.Model.Recipes;
import ru.example.worwebapi.Services.RecipesService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;

@RequestMapping("/recipes")
@RestController
public class RecipesController {
    public class RecipesService {
        private final ru.example.worwebapi.Services.RecipesService recipesService;

        public RecipesService(ru.example.worwebapi.Services.RecipesService recipesService) {
            this.recipesService = recipesService;
        }

        //Добавление рецепта.
        @PostMapping("/api/recipes/{createRecipes}")
        public ResponseEntity createRecipes(@RequestBody Recipes recipes) {
            Recipes createdRecipes = recipesService.createRecipes(recipes);
            return ResponseEntity.ok(createdRecipes);
        }

        //Редактирование рецепта по id.
        @GetMapping("/{recipesId}")
        public ResponseEntity getRecipes(@PathVariable Long recipesId) {
            Long recipes = recipesService.getRecipesById(recipesId);
            if (recipes == null) {
                return ResponseEntity.notFound().build();
            }
            return ResponseEntity.ok(recipes);
        }

        //Редактирование рецептов
        @PutMapping("/api/recipes/{updateRecipes}")
        public ResponseEntity updateRecipes(@RequestBody Recipes recipes) {
            Recipes updatedRecipes = recipesService.updateRecipes(recipes.getId(), recipes);
            return ResponseEntity.ok(updatedRecipes);
        }


        //Получение списка всех рецептов.
        @GetMapping("/api/recipes/{id}/{name}")
        @ResponseBody
        public String RecipesController(@PathVariable String name, @PathVariable int cookingTime, @PathVariable String ingredients, @PathVariable String cookingSteps, @PathVariable Long id) {
            return "ID: " + getRecipes(id) + ", name: " + name + ", time: " + cookingTime + ", ingredients: " + ingredients + ", Steps: " + cookingSteps;
        }

        //Удаление рецепта по id.
        @DeleteMapping("/recipes/{deleterecipes}")
        public RecipesService deleteRecipes(@PathVariable RecipesService recipesId) {
            RecipesService deleteRecipes = recipesId.deleteRecipes(recipesId);
            ;
            return deleteRecipes(recipesId);
        }

        @PostMapping("/recipes/createRecipesString")
        public String createRecipesString(@RequestBody ru.example.worwebapi.Model.Recipes recipes) {
            return toString();
        }

        @GetMapping("byMonth/{month}")
        public ResponseEntity<Object> getMonth(@PathVariable Month month) {
            try {
                Path path = recipesService.createMonthReport(month);
                if (Files.size(path) == 0) {

                    InputStreamResource resource = new InputStreamResource(new FileInputStream(path.toFile()));
                    return ResponseEntity.ok()
                            .contentType(MediaType.APPLICATION_JSON)
                            .contentLength(Files.size(path))
                            .header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=\"" + month + "raport.text\"")
                            .body(resource);
                } else {
                    return ResponseEntity.noContent().build();

                }
            } catch (IOException e) {
                e.printStackTrace();
                return ResponseEntity.internalServerError().body(e.getMessage());
            }

        }
    }

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> addRecipesFromFile(@RequestParam MultipartFile file) {
        try (InputStream stream = file.getInputStream()) {
            ru.example.worwebapi.Services.RecipesService recipesService = null;
            recipesService.addRecipesFromInputStream(stream);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

}



