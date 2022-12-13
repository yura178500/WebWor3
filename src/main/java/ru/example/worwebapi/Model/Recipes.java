package ru.example.worwebapi.Model;

import lombok.Data;

import java.util.Objects;

@Data
public abstract class Recipes {
    public  String name;
    public  int cookingTime;
    public String ingredients;
   public String cookingSteps;
   public Long id;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Recipes recipes = (Recipes) o;
        return cookingTime == recipes.cookingTime && name.equals(recipes.name) && ingredients.equals(recipes.ingredients) && cookingSteps.equals(recipes.cookingSteps) && id.equals(recipes.id);
    }

    @Override
    public String toString() {
        return "Recipes{" +
                "name='" + name + '\'' +
                ", cookingTime=" + cookingTime +
                ", ingredients='" + ingredients + '\'' +
                ", cookingSteps='" + cookingSteps + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, cookingTime, ingredients, cookingSteps, id);
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
        return id;
    }

    public String getName() {
        return name;
    }

    public Recipes createRecipes(Recipes recipes) {
        return recipes;
    }

    public Long getRecipesById(Long recipesId) {
        return recipesId;
    }

    public Recipes updateRecipes(Long recipesId, Recipes recipes) {
        return recipes;
    }

    public Long deleteRecipes(Long recipesId) {
        return recipesId;
    }


    public abstract Recipes getCookingTime(Recipes recipes);

    public abstract Recipes getIngredients(Recipes recipes);

    public abstract Recipes getCookingSteps(Recipes recipes);

    public abstract Recipes getName(Recipes recipes);
}

