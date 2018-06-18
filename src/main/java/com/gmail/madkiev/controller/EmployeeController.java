package com.gmail.madkiev.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.gmail.madkiev.model.Elixir;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class EmployeeController {
	
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);
	
	//Map to store employees, ideally we should use database
	Map<Integer, Elixir> elixirData = new HashMap<Integer, Elixir>();
	
	@RequestMapping(value = "/elixir", method = RequestMethod.GET)
	public @ResponseBody Elixir getTestElixir() {
		logger.info("Start getTestElixir");
		Elixir elixir = new Elixir();
		elixir.setId(1);
		elixir.setName("Elixir of health");
		elixir.setCreatedDate(new Date());
		elixirData.put(1, elixir);
		return elixir;
	}
	
	@RequestMapping(value = "/elixir/{id}", method = RequestMethod.GET)
	public @ResponseBody Elixir getElixir(@PathVariable("id") int elixirId) {
		logger.info("Start getEmployee. ID="+elixirId);
		
		return elixirData.get(elixirId);
	}
	
	@RequestMapping(value = ElixirRestURIConstants.GET_ALL_ELIXIRS, method = RequestMethod.GET)
	public @ResponseBody List<Elixir> getAllElixirs() {
		logger.info("Start getAllElixirs.");
		List<Elixir> elixirs = new ArrayList<Elixir>();
		Set<Integer> ElixirIdKeys = elixirData.keySet();
		for(Integer i : ElixirIdKeys){
			elixirs.add(elixirData.get(i));
		}
		return elixirs;
	}
	
	@RequestMapping(value = "/elixir", method = RequestMethod.POST)
	public @ResponseBody Elixir createElixir(@RequestBody Elixir elixir) {
		logger.info("Start createElixir.");
		elixir.setCreatedDate(new Date());
		elixirData.put(elixir.getId(), elixir);
		return elixir;
	}
	
	@RequestMapping(value = "/elixir/{id}", method = RequestMethod.DELETE)
	public @ResponseBody Elixir deleteElixir(@PathVariable("id") int elixirId) {
		logger.info("Start deleteElixir.");
		Elixir elixir = elixirData.get(elixirId);
		elixirData.remove(elixirId);
		return elixir;
	}

//	@RequestMapping(value = ElixirRestURIConstants.INPUT_ELIXIR, method = RequestMethod.POST)
//	public @ResponseBody Elixir inputValueElixir(@RequestBody Elixir elixir) {
//		logger.info("Start inputValueElixir.");
//		elixir.getDrops();
//		elixir.getCurrentVolume();
//		elixir.getAromaVolume();
//		elixir.getNecessaryVolumeOfBottle();
//		elixirData.put(elixir.getId(), elixir);
//		return elixir;
//	}
//
//	@RequestMapping(value = ElixirRestURIConstants.PROCESS_ELIXIR, method = RequestMethod.POST)
//	public @ResponseBody double processElixir(@RequestBody Elixir elixir) {
//		logger.info("Start processElixir.");
//		elixir.getDrops();
//		elixir.getVolumeInMl();
//		elixirData.put(elixir.getId(), elixir);
//		return elixir.getAromaVolume() / elixir.getCurrentVolume();
//
//	}
//
//
//	@RequestMapping(value = ElixirRestURIConstants.OUTPUT_IN_ML_ELIXIR, method = RequestMethod.POST)
//	public @ResponseBody double outPutValueElixirInMl(@RequestBody Elixir elixir) {
//		logger.info("Start outPutValueElixirInMl.");
//		elixir.getVolumeInMl();
//		elixir.getNecessaryVolumeOfBottle();
//		elixirData.put(elixir.getId(), elixir);
//		return elixir.getNecessaryAroma(); // in ml
//	}
//
//	@RequestMapping(value = ElixirRestURIConstants.OUTPUT_IN_DROPS_ELIXIR, method = RequestMethod.POST)
//	public @ResponseBody double outPutValueElixirInDrops(@RequestBody Elixir elixir){
//		logger.info("start outPutValueElixirInDrops");
//		elixir.getNecessaryAroma();
//		elixir.getDrops();
//		elixirData.put(elixir.getId(), elixir);
//		return elixir.getDropsOfAroma(); // in drops
//	}

}
