package com.gmail.madkiev.controller;


import com.gmail.madkiev.model.Elixir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/v1")
public class ConverterController {

    private static final Logger logger = LoggerFactory.getLogger(ElixirController.class);

//    Map<Integer, Elixir> elixirData = new HashMap<Integer, Elixir>();
//
//    @RequestMapping(value = "/elixir/input", method = RequestMethod.PUT) public @ResponseBody
//    Elixir inputValueElixir(@RequestBody Elixir elixir) {
//        logger.info("Start inputValueElixir.");
//        elixirData.put(elixir.getId(), elixir);
//        return elixir;
//    }
//
//
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
