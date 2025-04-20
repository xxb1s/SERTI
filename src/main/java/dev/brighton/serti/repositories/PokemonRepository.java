package dev.brighton.serti.repositories;

import dev.brighton.serti.entities.Pokemon;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface PokemonRepository extends CrudRepository<Pokemon, Long> {
    List<Pokemon> findPokemonsByName(String name);
}
