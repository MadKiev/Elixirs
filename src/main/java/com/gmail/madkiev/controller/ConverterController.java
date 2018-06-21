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

    Map<Integer, Elixir> elixirData = new HashMap<Integer, Elixir>();

    @RequestMapping(value = "/elixir/input", method = RequestMethod.PUT)
    public @ResponseBody
    Elixir inputValueElixir(@RequestBody Elixir elixir) {
        logger.info("Start inputValueElixir.");
        elixir.getId();
        elixir.getDrops();
        elixir.getCurrentVolume();
        elixir.getAromaVolume();
        elixir.getNecessaryVolumeOfBottle();
        elixirData.put(elixir.getId(), elixir);
        return elixir;
    }

    @RequestMapping(value = "/elixir/process", method = RequestMethod.POST)
    public @ResponseBody double processElixir(@RequestBody Elixir elixir) {
        logger.info("Start processElixir.");
        elixir.setDrops(33);
        elixir.setVolumeInMl(4);
        elixir.setAromaVolume(2);
        elixir.setCurrentVolume(10);
        elixir.getDrops();
        elixir.getVolumeInMl();
        elixirData.put(elixir.getId(), elixir);
        return elixir.getAromaVolume() / elixir.getCurrentVolume();

    }


    @RequestMapping(value = "/elixir/outputMl", method = RequestMethod.PUT)
    public @ResponseBody double outPutValueElixirInMl(@RequestBody Elixir elixir) {
        logger.info("Start outPutValueElixirInMl.");
        elixir.getVolumeInMl();
        elixir.getNecessaryVolumeOfBottle();
        elixirData.put(elixir.getId(), elixir);
        return elixir.getNecessaryAroma(); // in ml
    }

    @RequestMapping(value = "/elixir/outputDrops", method = RequestMethod.PUT)
    public @ResponseBody double outPutValueElixirInDrops(@RequestBody Elixir elixir){
        logger.info("start outPutValueElixirInDrops");
        elixir.getNecessaryAroma();
        elixir.getDrops();
        elixirData.put(elixir.getId(), elixir);
        return elixir.getDropsOfAroma(); // in drops
    }
}
