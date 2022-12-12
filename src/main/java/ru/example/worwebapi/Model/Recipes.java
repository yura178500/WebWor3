package ru.example.worwebapi.Model;

import lombok.Data;

import java.util.Objects;
@Data
public class Recipes {
    String name;
    int cookingTime;
    String ingredients;
    String cookingSteps;
    Long id;

    public Recipes(String name, int cookingTime, String ingredients, String cookingSteps, Long id) {
        this.name = name;
        this.cookingTime = cookingTime;
        this.ingredients = ingredients;
        this.cookingSteps = cookingSteps;
        this.id = id;
    }
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

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getCookingSteps() {
        return cookingSteps;
    }

    public void setCookingSteps(String cookingSteps) {
        this.cookingSteps = cookingSteps;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}