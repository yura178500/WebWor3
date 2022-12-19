package ru.example.worwebapi.Controllers;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.example.worwebapi.Model.Ingredient;
import ru.example.worwebapi.Services.IngredientService;


@RequestMapping("ingredient")
@RestController
public class IngredienController {
    private final IngredientService ingredientService;
    public IngredienController(IngredientService ingredientService) {
        this.ingredientService = ingredientService;
    }

    //Добавление ингредиента.
    @PostMapping("/api/recipes/{createIngredient}")
    public ResponseEntity createIngredient(@RequestBody Ingredient ingredient) {
        Ingredient createdUser = ingredientService.createIngredient(ingredient);
        return ResponseEntity.ok(createdUser);
    }

    //Редактирование ингредиента по id
    @GetMapping("{ingredientId}")
    public ResponseEntity getIngredient(@PathVariable Integer ingredientId) {
        Ingredient ingredient = ingredientService.getIngredientById();
        if (ingredient == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(ingredient);
    }

    //Редактирование ингредиента
    @PutMapping("/api/ingredient/{updateIngredient}")
    public ResponseEntity updateIngredient(@RequestBody Ingredient ingredient) {
        Ingredient updatedIngredient = ingredientService.updateIngredient(ingredient.getIngredientById(), ingredient);
        return ResponseEntity.ok(updatedIngredient);
    }

    //Получение полного списка ингредиентов.
    @GetMapping("/api/ingredient/{id}/{name}")
    @ResponseBody
    public String IngredienController(@PathVariable String nameIngredient, @PathVariable int numberIngredients, @PathVariable String unit, @PathVariable Long idIngredient) {
        return "ID: " + idIngredient + ", name: " + nameIngredient + ", numer: " + numberIngredients + ", unit: " + unit;
    }

    //Удаление ингредиента.
    @DeleteMapping("/recipes/{deleteingredient}")
    public IngredientService deleteIngredient(@PathVariable IngredientService ingredientId) {
        Ingredient deleteIngredient = ingredientId.deleteIngredient(ingredientId);
        return ingredientId;
    }


}