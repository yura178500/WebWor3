package ru.example.worwebapi.Controllers.Services.Model;

import java.util.HashMap;
import java.util.Map;

public class Ingredient {
    String nameIngredient;
    int numberIngredients;
    String unit;
    Long idIngredient;
    private static Map<Long,Ingredient> ingredientMap = new HashMap<>();
    public static Long deleteIngredient(Long ingredientId) {
        return ingredientMap.remove(ingredientId).getIdIngredient();
    }

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNameIngredient(String nameIngredient) {
        this.nameIngredient = nameIngredient;
    }

    public int getNumberIngredients() {
        return numberIngredients;
    }

    public void setNumberIngredients(int numberIngredients) {
        this.numberIngredients = numberIngredients;
    }
    public String getUnit() {
        return unit;
    }

    public Long getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Long idIngredient) {
        this.idIngredient = idIngredient;
    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return null;
    }

    public Ingredient getIngredientById(Long ingredienId) {
        return null;
    }

    public Ingredient updateIngredient(Long idIngredient, Ingredient ingredient) {
        return null;
    }
}
