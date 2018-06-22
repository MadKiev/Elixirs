package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.Ingredient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mveselov on 6/22/2018.
 */
public class InMemoryIngredientRepository implements IngredientRepository {

    Map<String, Ingredient> ingredientMap = new HashMap<>();

    @Override
    public List<Ingredient> getIngredients() {
        return new ArrayList<>(ingredientMap.values());
    }

    @Override
    public Ingredient getIngredient(String id) {
        return ingredientMap.get(id);
    }

    @Override
    public Ingredient saveIngredient(Ingredient ingredient) {
        ingredientMap.put(ingredient.getId(), ingredient);
        return ingredientMap.get(ingredient.getId());
    }

    @Override
    public void deleteIngredient(String id) {
        ingredientMap.remove(id);
    }
}
