package dev.brighton.serti.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeDTO {
    private Short id;
    private String name;

    @JsonProperty("id")
    private Short apiId;

    public TypeDTO() {}

    public TypeDTO(Short id, String name, Short apiId) {
        this.id = id;
        this.name = name;
        this.apiId = apiId;
    }

    public Short getId() {
        return id;
    }

    public void setId(Short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Short getApiId() {
        return apiId;
    }

    public void setApiId(Short apiId) {
        this.apiId = apiId;
    }
}
