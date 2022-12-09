package ru.example.worwebapi.Controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.worwebapi.Controllers.Services.Recipes;


@RequestMapping("recipes")
@RestController
class RecipesController {
    public Recipes recipes;

    public void RecipesController(Recipes recipes) {
        this.recipes = recipes;
    }

    //Добавление рецепта.
    @PostMapping("/recipes/createRecipes")
    public ResponseEntity createRecipes(@RequestBody Recipes recipes) {
        Recipes createdRecipes = Recipes.createRecipes(recipes);
        return ResponseEntity.ok(createdRecipes);
    }

    //Получение рецепта по id.
    @GetMapping("{recipesId}")
    public ResponseEntity getRecipes(@PathVariable Long recipesId) {
        Recipes recipes = Recipes.getRecipesId(recipesId);
        if (recipes == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(recipes);
    }
    //Редактирование рецепта по id.
    @PutMapping("/recipes/updateRecipes")
    public ResponseEntity updateRecipes(@RequestBody Recipes recipes) {
        Recipes updatedRecipes = Recipes.updateRecipes(recipes.getId(), recipes);
        return ResponseEntity.ok(updatedRecipes);
    }

    //Получение списка всех рецептов.
    @GetMapping("/api/recipes/{id}/{name}")
    @ResponseBody
    public String RecipesController(@PathVariable Long recipesId, @PathVariable String getName) {
        return "ID: " + recipesId + ", name: " + getName;
    }

    //Удаление рецепта по id.
    @DeleteMapping("/recipes/deleterecipes")
    public ResponseEntity deleteRecipes(@PathVariable Long recipesId) {
        Recipes deleteRecipes = Recipes.deleteRecipes(recipesId);
        return (ResponseEntity) Recipes.recipes.remove(recipesId);
    }

}

