package ru.example.worwebapi.Model;
import lombok.Data;

import java.util.Objects;
@Data
public class Ingredient {
    String nameIngredient;
    int numberIngredients;
    String unit;
    Long idIngredient;


    public Ingredient(String nameIngredient, int numberIngredients, String unit, Long idIngredient) {
        this.nameIngredient = nameIngredient;
        this.numberIngredients = numberIngredients;
        this.unit = unit;
        this.idIngredient = idIngredient;

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

    @Override
    public String toString() {
        return "Ingredient{" +
                "nameIngredient='" + nameIngredient + '\'' +
                ", numberIngredients=" + numberIngredients +
                ", unit='" + unit + '\'' +
                ", idIngredient=" + idIngredient +
                '}';
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return numberIngredients == that.numberIngredients && nameIngredient.equals(that.nameIngredient) && unit.equals(that.unit) && idIngredient.equals(that.idIngredient);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nameIngredient, numberIngredients, unit, idIngredient);
    }
}
