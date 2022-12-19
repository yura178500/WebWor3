package ru.example.worwebapi.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recipes implements Map<Long, Recipes> {
    private   String name;
    private   int cookingTime;
    private String ingredients;
   private String cookingSteps;
   private Long recipesId;

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
    public Recipes get(Object key) {
        return null;
    }
    @Nullable
    @Override
    public Recipes put(Long key, Recipes value) {
        return null;
    }

    @Override
    public Recipes remove(Object key) {
        return null;
    }

    @Override
    public void putAll(@NotNull Map<? extends Long, ? extends Recipes> m) {

    }

    @Override
    public void clear() {

    }

    @NotNull
    @Override
    public Set<Long> keySet() {
        return null;
    }

    @NotNull
    @Override
    public Collection<Recipes> values() {
        return null;
    }

    @NotNull
    @Override
    public Set<Entry<Long, Recipes>> entrySet() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return cookingTime == recipes.cookingTime && name.equals(recipes.name) && ingredients.equals(recipes.ingredients) && cookingSteps.equals(recipes.cookingSteps) && recipesId.equals(recipes.recipesId);
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "name='" + name + '\'' +
                ", cookingTime=" + cookingTime +
                ", ingredients='" + ingredients + '\'' +
                ", cookingSteps='" + cookingSteps + '\'' +
                ", id=" + recipesId +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cookingTime, ingredients, cookingSteps, recipesId);
    }

    public int getCookingTime() {
        return cookingTime;
    }

       public String getIngredients() {
        return ingredients;
    }

      public String getCookingSteps() {
        return cookingSteps;
    }

       public Long getId() {
        return recipesId;
    }}





