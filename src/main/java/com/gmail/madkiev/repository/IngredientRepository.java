package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.Ingredient;

import java.util.List;

/**
 * Created by mveselov on 6/22/2018.
 */
public interface IngredientRepository {

    List<Ingredient> getIngredients();
    Ingredient getIngredient(String id);
    Ingredient saveIngredient(Ingredient ingredient);
    void deleteIngredient(String id);

}
