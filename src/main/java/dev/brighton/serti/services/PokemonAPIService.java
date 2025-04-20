package dev.brighton.serti.services;

import dev.brighton.serti.dtos.PokemonDTO;
import dev.brighton.serti.dtos.TypeDTO;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.web.reactive.function.client.WebClientResponseException;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Service
public class PokemonAPIService {
    private final WebClient webClient;

    public PokemonAPIService() {
        Dotenv dotenv = Dotenv.load();

        this.webClient = WebClient.builder()
                .baseUrl(dotenv.get("POKEMON_API_URL"))
                .build();
    }

    public Optional<PokemonDTO> getPokemonByPokedex(Long pokedex) {
        try {
            PokemonDTO pokemonDTO = webClient.get()
                    .uri(String.format("/pokemon/%d", pokedex))
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError(), response ->
                        response.createException().flatMap(Mono::error)
                    )
                    .bodyToMono(PokemonDTO.class)
                    .block();

            return Optional.ofNullable(pokemonDTO);
        } catch (WebClientResponseException e) {
            return Optional.empty();
        }
    }

    public Optional<TypeDTO> getTypeById(Long id) {
        try {
            TypeDTO typeDTO = webClient.get()
                    .uri(String.format("/type/%d", id))
                    .retrieve()
                    .onStatus(status -> status.is4xxClientError(), response ->
                        response.createException().flatMap(Mono::error)
                    )
                    .bodyToMono(TypeDTO.class)
                    .block();

            return Optional.ofNullable(typeDTO);
        } catch (WebClientResponseException e) {
            return Optional.empty();
        }
    }
}
