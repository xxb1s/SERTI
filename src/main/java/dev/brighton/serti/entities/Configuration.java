package dev.brighton.serti.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "configurations")
public class Configuration {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "max_teams", nullable = false)
    private Byte maxTeams;

    @Column(name = "max_pokemon", nullable = false)
    private Byte maxPokemon;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "created_by_user_id", nullable = false)
    private User createdByUser;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "deleted_at")
    private Instant deletedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getMaxTeams() {
        return maxTeams;
    }

    public void setMaxTeams(Byte maxTeams) {
        this.maxTeams = maxTeams;
    }

    public Byte getMaxPokemon() {
        return maxPokemon;
    }

    public void setMaxPokemon(Byte maxPokemon) {
        this.maxPokemon = maxPokemon;
    }

    public User getCreatedByUser() {
        return createdByUser;
    }

    public void setCreatedByUser(User createdByUser) {
        this.createdByUser = createdByUser;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getDeletedAt() {
        return deletedAt;
    }

    public void setDeletedAt(Instant deletedAt) {
        this.deletedAt = deletedAt;
    }

}