package ru.example.worwebapi.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.worwebapi.Model.Recipes;

import java.util.Map;

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

        @GetMapping("/api/employeeswithmapvariable/{id}/{name}")
        @ResponseBody
        public String getEmployeesByIdAndNameWithMapVariable(@PathVariable Map<String, String> pathVarsMap) {
            String id = pathVarsMap.get("id");
            String name = pathVarsMap.get("name");
            if (id != null && name != null) {
                return "ID: " + id + ", name: " + name;
            } else {
                return "Missing Parameters";
            }
        }
    }
}



