package ru.example.worwebapi.Services.impl;


import ru.example.worwebapi.Model.Ingredient;

public class IngredientImpl extends Ingredient {

    public IngredientImpl(String nameIngredient, int numberIngredients, String unit, Long idIngredient) {
        super(nameIngredient, numberIngredients, unit, idIngredient);
    }
    public String getNameIngredient() {
        return null;
    }
    public int getNumberIngredients() {
        return 0;
    }
    public String getUnit() {
        return null;
    }
    public Long getIdIngredient() {
        return null;
    }
}