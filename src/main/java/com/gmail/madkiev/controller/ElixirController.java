package com.gmail.madkiev.controller;

import java.util.*;

import com.gmail.madkiev.model.Elixir;
import com.gmail.madkiev.repository.ElixirRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api/v1")
public class ElixirController {
	
	private static final Logger logger = LoggerFactory.getLogger(ElixirController.class);

	@Autowired
	private ElixirRepository elixirRepository;

	
	@RequestMapping(value = "/elixir", method = RequestMethod.GET)
	public @ResponseBody Elixir getTestElixir() {
		logger.info("Start getTestElixir");
		Elixir elixir = new Elixir();
		elixir.setId(UUID.randomUUID().toString());
		elixir.setName("Elixir of health");
		elixirRepository.saveElixir(elixir);
		return elixir;
	}
	
	@RequestMapping(value = "/elixir/{id}", method = RequestMethod.GET)
	public @ResponseBody Elixir getElixir(@PathVariable("id") String elixirId) {
		logger.info("Start getElixir. ID="+elixirId);
		
		return elixirRepository.getElixir(elixirId);
	}
	
	@RequestMapping(value = "/elixirs", method = RequestMethod.GET)
	public @ResponseBody List<Elixir> getAllElixirs() {
		logger.info("Start getAllElixirs.");
		return elixirRepository.getElixir();
	}
	
	@RequestMapping(value = "/elixir", method = RequestMethod.POST)
	public @ResponseBody Elixir createElixir(@RequestBody Elixir elixir) {
		logger.info("Start createElixir.");
		return elixirRepository.saveElixir(elixir);
	}
	
	@RequestMapping(value = "/elixir/{id}", method = RequestMethod.DELETE)
	public @ResponseBody
	void deleteElixir(@PathVariable("id") String elixirId) {
		logger.info("Start deleteElixir.");
		elixirRepository.deleteElixir(elixirId);
	}
}
