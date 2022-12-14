package ru.example.worwebapi.Model;

import lombok.Data;
import ru.example.worwebapi.Services.IngredientService;

import java.util.Objects;


@Data
public abstract class Ingredient {
   private String nameIngredient;
   private int numberIngredients;
   private String unit;

    public String getNameIngredient() {
        return nameIngredient;
    }

    public void setNumberIngredients(int numberIngredients) {
        this.numberIngredients = numberIngredients;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return "Ingredient{" +
                "nameIngredient='" + nameIngredient + '\'' +
                ", numberIngredients=" + numberIngredients +
                ", unit='" + unit + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return numberIngredients == that.numberIngredients && nameIngredient.equals(that.nameIngredient) && unit.equals(that.unit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameIngredient, numberIngredients, unit);


    }

    public Ingredient createIngredient(Ingredient ingredient) {
        return ingredient;
    }

    public Integer getIngredientById() {
        return getIngredientById();
    }

    public Ingredient updateIngredient(Long ingredientId, Ingredient ingredient) {
        return ingredient;
    }

    public Ingredient getIngredientById(Integer ingredientId) {
        return null;
    }

    public Ingredient updateIngredient(Integer ingredientId, Ingredient ingredient) {
        return ingredient;
    }

     public void setIdIngredient(Integer idIngredient) {

    }

    public Ingredient deleteIngredient(IngredientService ingredientId) {
        return ingredientId;
    }

    public abstract Ingredient getNameIngredient(Ingredient ingredient);

    public abstract Ingredient getNumberIngredients(Ingredient ingredient);

    public abstract Ingredient getUnit(Ingredient ingredient);
}