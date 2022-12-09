package ru.example.worwebapi.Controllers;


import org.jetbrains.annotations.NotNull;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.worwebapi.Controllers.Services.Model.Ingredient;


@RequestMapping("ingredien")
@RestController
class IngredienController {
    private Ingredient ingredient;

    public void IngredienController(Ingredient ingredient) {
        this.ingredient = ingredient;

    }

    //Добавление ингредиента.
    @PostMapping
    public ResponseEntity createIngredien(@RequestBody @NotNull Ingredient ingredient) {
        Ingredient createIngredien = ingredient.createIngredient(ingredient);
        return ResponseEntity.ok(createIngredien);
    }

    //Получение информации об ингредиенте по id.
    @GetMapping("{ingredienId}")
    public ResponseEntity getIngredien(@PathVariable Long ingredienId) {
        Ingredient ingredient = this.ingredient.getIngredientById(ingredienId);
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(this.ingredient);
    }
    //Редактирование ингредиента по id.
    @PutMapping()
    public ResponseEntity updateIngredien(@RequestBody Ingredient ingredient) {
        Ingredient updatedIngredient = ingredient.updateIngredient(ingredient.getIdIngredient(), ingredient);
        return ResponseEntity.ok(updatedIngredient);
    }

    //Получение полного списка ингредиентов.
    @GetMapping("/api/ingredient/{id}/{name}")
    @ResponseBody
    public String IngredienController(@PathVariable String idIngredient, @PathVariable String nameIngredien) {
        return "ID: " + idIngredient + ", name: " + nameIngredien;
    }

    //Удаление ингредиента.
    @DeleteMapping("/recipes/deleteingredient")
    public Long deleteIngredient(@PathVariable Long ingredientId) {
        Long deleteIngredient = Ingredient.deleteIngredient(ingredientId);
        return Ingredient.deleteIngredient(ingredientId);
}}