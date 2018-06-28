package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.Elixir;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryElixirRepository implements ElixirRepository{
    Map<String, Elixir> elixirMap = new HashMap<>();

    @Override
    public List<Elixir> getElixir() {
        return new ArrayList<>(elixirMap.values());
    }

    @Override
    public Elixir getElixir(String id) {
        return elixirMap.get(id);
    }

    @Override
    public Elixir saveElixir(Elixir elixir) {
        elixirMap.put(elixir.getId(), elixir);
        return elixirMap.get(elixir.getId());
    }

    @Override
    public void deleteElixir(String id) {
        elixirMap.remove(id);
    }

}
