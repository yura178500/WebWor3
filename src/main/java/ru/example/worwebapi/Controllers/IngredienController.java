package ru.example.worwebapi.Controllers;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.example.worwebapi.Model.Ingredient;
import ru.example.worwebapi.Services.IngredientService;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Month;
import java.util.Map;


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

    @GetMapping("byMonth/{month}")
    public ResponseEntity<Object> getMonth(@PathVariable Month month) {
        try {
            Path path = ingredientService.createMonthReport(month);
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

    @PostMapping(value = "/import", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<Object> addIngredientFromFile(@RequestParam MultipartFile file) {
        try (InputStream stream = file.getInputStream()) {
            ru.example.worwebapi.Services.IngredientService ingredientService = null;
            ingredientService.addIngredientFromInputStream(stream);
            return ResponseEntity.ok().build();
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body(e.getMessage());
        }

    }

    @GetMapping("/ingredients/{ingredientId}")
    public Ingredient getIngredient(@PathVariable Long ingredientId) {
        return ingredientService.getIngredientById(ingredientId);
    }

    @GetMapping("/ingredients/all")
    public Map<Long, Ingredient> getAllIngredients() {
        return ingredientService.getAllIngredients();
    }


    @PostMapping("/add")
    public void addIngredient(@PathVariable Long ingredientId, @RequestBody Ingredient ingredient) {
        ingredientService.addIngredient(ingredient);
    }

}