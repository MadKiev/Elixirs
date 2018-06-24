package com.gmail.madkiev.repository;

import com.gmail.madkiev.model.Elixir;

import java.util.List;

public interface ElixirRepository {

    List<Elixir> getElixir();
    Elixir getElixir(String id);
    Elixir saveElixir(Elixir elixir);
    void deleteElixir(String id);
    Elixir addVolume(String volume);
}
