package dev.brighton.serti.services;

import dev.brighton.serti.dtos.PokemonDTO;
import dev.brighton.serti.entities.Pokemon;
import dev.brighton.serti.repositories.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;
    private PokemonAPIService pokemonAPIService;
    private TypeService typeService;

    public List<PokemonDTO> listAll() {
        Iterable<Pokemon> pokemonIterable = pokemonRepository.findAll();

        return StreamSupport.stream(pokemonIterable.spliterator(), false)
                .map(this::convertPokemonToDTO)
                .collect(Collectors.toList());
    }

    public List<PokemonDTO> getByNameOrId(String pokemonNameOrId) {
        List<PokemonDTO> pokemonList = new ArrayList<PokemonDTO>();

        Optional<Pokemon> pokemonOpt = pokemonRepository.findById(Long.parseLong(pokemonNameOrId));

        if (pokemonOpt.isPresent()) {
            pokemonList.add(this.convertPokemonToDTO(pokemonOpt.get()));
            return pokemonList;
        }

        pokemonList.addAll(
                pokemonRepository
                        .findPokemonsByName(pokemonNameOrId)
                        .stream()
                        .map(this::convertPokemonToDTO)
                        .toList()
        );

        return pokemonList;
    }

    public void searchAndSavePokemon(String pokemon) {
        Optional<PokemonDTO> pokemonViaAPI = pokemonAPIService.getPokemonByPokedex(Long.parseLong(pokemon));

        if (!pokemonViaAPI.isPresent()) {
            //return new PokemonDTO();
        }

        PokemonDTO pokemonDTO = pokemonViaAPI.get();


    }

    public PokemonDTO convertPokemonToDTO(Pokemon pokemon) {
        return new PokemonDTO(pokemon.getId(), pokemon.getName(), pokemon.getPokedexId());
    }
}
