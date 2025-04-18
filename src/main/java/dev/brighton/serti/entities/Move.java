package dev.brighton.serti.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.time.Instant;

@Entity
@Table(name = "moves")
public class Move {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "api_id", nullable = false)
    private Long apiId;

    @Column(name = "name", nullable = false, length = 100)
    private String name;

    @Column(name = "accurracy", nullable = false, columnDefinition = "int UNSIGNED not null")
    private Long accurracy;

    @Column(name = "power_points", nullable = false, columnDefinition = "int UNSIGNED not null")
    private Long powerPoints;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ColumnDefault("CURRENT_TIMESTAMP")
    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getApiId() {
        return apiId;
    }

    public void setApiId(Long apiId) {
        this.apiId = apiId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getAccurracy() {
        return accurracy;
    }

    public void setAccurracy(Long accurracy) {
        this.accurracy = accurracy;
    }

    public Long getPowerPoints() {
        return powerPoints;
    }

    public void setPowerPoints(Long powerPoints) {
        this.powerPoints = powerPoints;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

}