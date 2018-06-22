package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryRecipeRepository implements RecipeRepository {
    Map<String, Recipe> recipeMap = new HashMap<>();

    @Override
    public List<Recipe> getRecipe() {
        return new ArrayList<>(recipeMap.values());
    }

    @Override
    public Recipe getRecipe(String id) {
        return recipeMap.get(id);
    }

    @Override
    public Recipe saveRecipe(Recipe recipe) {
        recipeMap.put(recipe.getId(), recipe);
        return recipeMap.get(recipe.getId());
    }

    @Override
    public void deleteRecipe(String id) {
        recipeMap.remove(id);
    }
}
