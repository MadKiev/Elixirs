package com.gmail.madkiev.controller;

import com.gmail.madkiev.model.Elixir;
import com.gmail.madkiev.model.Recipe;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/v1")
public class RecipeController {
    private static final Logger logger = LoggerFactory.getLogger(ElixirController.class);

    //Map to store recipes
    Map<Integer, Recipe> recipeData = new HashMap<>();

    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    public @ResponseBody
    Recipe getTestRecipe() {
        logger.info("Start getTestRecipe");
        Recipe recipe = new Recipe();
        recipe.setId(1);
        recipe.setName("Powerful recipe");
        recipeData.put(1, recipe);
        return recipe;
    }

    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
    public @ResponseBody Recipe getRecipe(@PathVariable("id") int recipeId) {
        logger.info("Start getRecipe. ID="+recipeId);

        return recipeData.get(recipeId);
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public @ResponseBody
    List<Recipe> getAllRecipe() {
        logger.info("Start getAllRecipes.");
        List<Recipe> recipes = new ArrayList<>();
        Set<Integer> RecipeIdKeys = recipeData.keySet();
        for(Integer i : RecipeIdKeys){
            recipes.add(recipeData.get(i));
        }
        return recipes;
    }

    @RequestMapping(value = "/recipe", method = RequestMethod.POST)
    public @ResponseBody Recipe createRecipe(@RequestBody Recipe recipe) {
        logger.info("Start createRecipe.");
        recipeData.put(recipe.getId(), recipe);
        return recipe;
    }

    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.DELETE)
    public @ResponseBody Recipe deleteRecipe(@PathVariable("id") int recipeId) {
        logger.info("Start deleteRecipe.");
        Recipe recipe = recipeData.get(recipeId);
        recipeData.remove(recipeId);
        return recipe;
    }
}
