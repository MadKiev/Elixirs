package com.gmail.madkiev.controller;

import com.gmail.madkiev.model.Elixir;
import com.gmail.madkiev.model.Ingredient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/v1")
public class IngredientController {

    private static final Logger logger = LoggerFactory.getLogger(ElixirController.class);

    //Map to store Ingredients
    Map<Integer, Ingredient> ingredientData = new HashMap<>();

    @RequestMapping(value = "/ingredient", method = RequestMethod.GET)
    public @ResponseBody
    Ingredient getTestIngredient() {
        logger.info("Start getTestIngredient");
        Ingredient ingredient = new Ingredient();
        ingredient.setId(1);
        ingredient.setName("Secret ingredient");
        ingredientData.put(1, ingredient);
        return ingredient;
    }

    @RequestMapping(value = "/ingredient/{id}", method = RequestMethod.GET)
    public @ResponseBody Ingredient getIngredient(@PathVariable("id") int ingredientId) {
        logger.info("Start getIngredient. ID="+ingredientId);

        return ingredientData.get(ingredientId);
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public @ResponseBody
    List<Ingredient> getAllIngredientId() {
        logger.info("Start getAllIngredients.");
        List<Ingredient> ingredients = new ArrayList<>();
        Set<Integer> IngredientsIdKeys = ingredientData.keySet();
        for(Integer i : IngredientsIdKeys){
            ingredients.add(ingredientData.get(i));
        }
        return ingredients;
    }

    @RequestMapping(value = "/ingredient", method = RequestMethod.POST)
    public @ResponseBody Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        logger.info("Start createIngredient.");
        ingredientData.put(ingredient.getId(), ingredient);
        return ingredient;
    }

    @RequestMapping(value = "/ingredient/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Ingredient deleteIngredient(@PathVariable("id") int ingredientId) {
        logger.info("Start deleteIngredient.");
        Ingredient ingredient = new Ingredient();
        ingredientData.get(ingredientId);
        ingredientData.remove(ingredientId);
        return ingredient;
    }
}
