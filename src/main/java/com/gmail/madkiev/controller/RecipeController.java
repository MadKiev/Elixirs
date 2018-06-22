package com.gmail.madkiev.controller;

import com.gmail.madkiev.model.Recipe;
import com.gmail.madkiev.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@Controller
@RequestMapping("/api/v1")
public class RecipeController {
    private static final Logger logger = LoggerFactory.getLogger(ElixirController.class);

    @Autowired
    private RecipeRepository recipeRepository;

    @RequestMapping(value = "/recipe", method = RequestMethod.GET)
    public @ResponseBody
    Recipe getTestRecipe() {
        logger.info("Start getTestRecipe");
        Recipe recipe = new Recipe();
        recipe.setId(UUID.randomUUID().toString());
        recipe.setName("Powerful recipe");
        recipeRepository.saveRecipe(recipe);
        return recipe;
    }

    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.GET)
    public @ResponseBody Recipe getRecipe(@PathVariable("id") String recipeId) {
        logger.info("Start getRecipe. ID="+recipeId);

        return recipeRepository.getRecipe(recipeId);
    }

    @RequestMapping(value = "/recipes", method = RequestMethod.GET)
    public @ResponseBody
    List<Recipe> getAllRecipe() {
        logger.info("Start getAllRecipes.");
        return recipeRepository.getRecipe();
    }

    @RequestMapping(value = "/recipe", method = RequestMethod.POST)
    public @ResponseBody Recipe createRecipe(@RequestBody Recipe recipe) {
        logger.info("Start createRecipe.");
        return recipeRepository.saveRecipe(recipe);
    }

    @RequestMapping(value = "/recipe/{id}", method = RequestMethod.DELETE)
    public @ResponseBody
    void deleteRecipe(@PathVariable("id") String recipeId) {
        logger.info("Start deleteRecipe.");
        recipeRepository.deleteRecipe(recipeId);
    }
}
