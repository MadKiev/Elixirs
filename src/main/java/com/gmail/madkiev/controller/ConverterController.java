package com.gmail.madkiev.controller;


import com.gmail.madkiev.model.Elixir;
import com.gmail.madkiev.model.Recipe;
import com.gmail.madkiev.repository.ElixirRepository;
import com.gmail.madkiev.repository.IngredientRepository;
import com.gmail.madkiev.repository.RecipeRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class ConverterController {

    private static final Logger logger = LoggerFactory.getLogger(ElixirController.class);

    @Autowired
    private ElixirRepository elixirRepository;

    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @RequestMapping(value = "/elixir/input{id}", method = RequestMethod.POST) public @ResponseBody
    Elixir inputValueElixir(@PathVariable("id") String elixirId) {
        //передовать айди еликсира и желаемый обьем
        logger.info("Start inputValueElixir.");
        return elixirRepository.addVolume(elixirId);
    }


//    @RequestMapping(value = "/elixir/process", method = RequestMethod.POST)
//    public @ResponseBody
//    Elixir processElixir(@RequestBody Elixir elixir) {
//        logger.info("Start processElixir.");
//        elixirData.put(elixir.getId(), elixir);
//        return elixir;
//
//    }
//
//
//    @RequestMapping(value = "/elixir/outputMl", method = RequestMethod.PUT)
//    public @ResponseBody
//    Elixir outPutValueElixir(@RequestBody Elixir elixir) {
//        logger.info("Start outPutValueElixirInMl.");
//        elixirData.put(elixir.getId(), elixir);
//        return elixir;
//    }
}