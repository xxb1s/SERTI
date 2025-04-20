package dev.brighton.serti.controllers;

import dev.brighton.serti.dtos.PokemonDTO;
import dev.brighton.serti.services.PokemonAPIService;
import dev.brighton.serti.services.PokemonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/pokemon")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;
    @Autowired
    private PokemonAPIService pokemonAPIService;
    
    @GetMapping
    public Iterable<PokemonDTO> listAll() {
        return pokemonService.listAll();
    }

    @GetMapping("/{pokemon}")
    public ResponseEntity<List<PokemonDTO>> getPokemon(@PathVariable String pokemon) {
        List<PokemonDTO> pokemonList = pokemonService.getByNameOrId(pokemon);

        if (!pokemonList.isEmpty()) {
            return ResponseEntity.ok(pokemonList);
        }

        pokemonService.searchAndSavePokemon(pokemon);

        return ResponseEntity.ok(pokemonList);
    }
}
