package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.Recipe;

import java.util.List;

public interface RecipeRepository {
    List<Recipe> getRecipe();
    Recipe getRecipe(String id);
    Recipe saveRecipe(Recipe recipe);
    void deleteRecipe(String id);
}
