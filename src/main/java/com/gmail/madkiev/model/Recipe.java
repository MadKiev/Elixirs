package com.gmail.madkiev.model;

import java.util.HashMap;
import java.util.Map;

public class Recipe{
    private String id;
    private String name;
    private Map<Ingredient, Double> elixirData = new HashMap<>();

    public Map<Ingredient, Double> getElixirData() {
        return elixirData;
    }

    public void setElixirData(Map<Ingredient, Double> elixirData) {
        this.elixirData = elixirData;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
