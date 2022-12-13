package ru.example.worwebapi.Model;

import lombok.Data;
import lombok.Getter;
import ru.example.worwebapi.Services.IngredientService;

import java.util.Objects;


@Data
public abstract class Ingredient {
    String nameIngredient;
    int numberIngredients;
    String unit;

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

    public abstract Ingredient createIngredient(Ingredient ingredient);

    public abstract Integer getIngredientById();

    public abstract Ingredient updateIngredient(Long ingredientId, Ingredient ingredient);

    public abstract Ingredient getIngredientById(Integer ingredientId);

    public abstract Ingredient updateIngredient(Integer ingredientId, Ingredient ingredient);

    public abstract void setIdIngredient(Long idIngredient);

    public abstract void setIdIngredient(Integer idIngredient);

    public abstract Ingredient deleteIngredient(IngredientService ingredientId);

    public abstract Ingredient getNameIngredient(Ingredient ingredient);

    public abstract Ingredient getNumberIngredients(Ingredient ingredient);

    public abstract Ingredient getUnit(Ingredient ingredient);
}