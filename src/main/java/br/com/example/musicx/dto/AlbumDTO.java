package br.com.example.musicx.dto;

import javax.validation.constraints.NotBlank;

public class AlbumDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String category;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
