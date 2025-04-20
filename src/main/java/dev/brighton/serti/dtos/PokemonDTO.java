package dev.brighton.serti.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PokemonDTO {
    private Long id;

    private String name;

    @JsonProperty("id")
    private Long pokedexId;

    private Long typeId;

    public PokemonDTO() {}

    public PokemonDTO(Long id, String name, Long pokedexId) {
        this.id = id;
        this.name = name;
        this.pokedexId = pokedexId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getPokedexId() {
        return pokedexId;
    }

    public void setPokedexId(Long pokedexId) {
        this.pokedexId = pokedexId;
    }
}
