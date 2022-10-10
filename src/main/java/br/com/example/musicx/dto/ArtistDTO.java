package br.com.example.musicx.dto;

import javax.validation.constraints.NotBlank;

public class ArtistDTO {
    @NotBlank
    private String name;
    private int rating;

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
