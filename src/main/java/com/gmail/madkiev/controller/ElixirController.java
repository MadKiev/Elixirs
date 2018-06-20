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
public class ElixirController {
	
	private static final Logger logger = LoggerFactory.getLogger(ElixirController.class);
	
	//Map to store elixirs
	Map<Integer, Elixir> elixirData = new HashMap<Integer, Elixir>();
	
	@RequestMapping(value = "/elixir", method = RequestMethod.GET)
	public @ResponseBody Elixir getTestElixir() {
		logger.info("Start getTestElixir");
		Elixir elixir = new Elixir();
		elixir.setId(1);
		elixir.setCurrentVolume(30);
		elixir.setAromaVolume(3);
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
	
	@RequestMapping(value = "/elixirs", method = RequestMethod.GET)
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
//////////////////////////////////////////////////////////////////////

}
