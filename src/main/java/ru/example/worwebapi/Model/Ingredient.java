package ru.example.worwebapi.Model;

import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import ru.example.worwebapi.Services.IngredientService;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;


@Data
public  class Ingredient implements Map<Integer, Ingredient> {
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
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Ingredient get(Object key) {
        return null;
    }

    @Nullable
    @Override
    public Ingredient put(Integer key, Ingredient value) {
        return null;
    }

    @Override
    public Ingredient remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends Integer, ? extends Ingredient> m) {

    }

    @Override
    public void clear() {

    }

    @NotNull
    @Override
    public Set<Integer> keySet() {
        return null;
    }

    @NotNull
    @Override
    public Collection<Ingredient> values() {
        return null;
    }

    @NotNull
    @Override
    public Set<Entry<Integer, Ingredient>> entrySet() {
        return null;
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
        return ingredientId.getIngredientById();
    }


}