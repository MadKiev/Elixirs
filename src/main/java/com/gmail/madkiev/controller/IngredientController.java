package com.gmail.madkiev.controller;

import com.gmail.madkiev.model.Ingredient;
import com.gmail.madkiev.repository.IngredientRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.UUID;

@Controller
@RequestMapping("/api/v1")
public class IngredientController {

    private static final Logger logger = LoggerFactory.getLogger(IngredientController.class);

    @Autowired
    private IngredientRepository ingredientRepository;

    @RequestMapping(value = "/ingredient", method = RequestMethod.GET)
    public @ResponseBody
    Ingredient getTestIngredient() {
        logger.info("Start getTestIngredient");
        Ingredient ingredient = new Ingredient();
        ingredient.setId(UUID.randomUUID().toString());
        ingredient.setName("Secret ingredient");
        ingredientRepository.saveIngredient(ingredient);
        return ingredient;
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Ingredient getIngredient(@PathVariable("id") String ingredientId) {
        logger.info("Start getIngredient. ID="+ingredientId);

        return ingredientRepository.getIngredient(ingredientId);
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.GET)
    public @ResponseBody
    List<Ingredient> getAllIngredientId() {
        logger.info("Start getAllIngredients.");
        return ingredientRepository.getIngredients();
    }

    @RequestMapping(value = "/ingredients", method = RequestMethod.POST)
    public @ResponseBody
    Ingredient createIngredient(@RequestBody Ingredient ingredient) {
        logger.info("Start createIngredient.");
        return ingredientRepository.saveIngredient(ingredient);
    }

    @RequestMapping(value = "/ingredients/{id}", method = RequestMethod.DELETE)
    public @ResponseBody void deleteIngredient(@PathVariable("id") String ingredientId) {
        logger.info("Start deleteIngredient.");
        ingredientRepository.deleteIngredient(ingredientId);
    }
}
