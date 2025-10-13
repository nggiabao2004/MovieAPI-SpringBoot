package com.nggiabao2004.MovieAPI.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieDto {
    private Integer movieId;
    @NotBlank(message = "Please provide movie's title!")
    private String title;
    @NotBlank(message = "Please provide movie's director!")
    private String director;
    @NotBlank(message = "Please provide movie's rating!")
    private String rating;
    @NotBlank(message = "Please provide movie's studio!")
    private String studio;
    @ElementCollection
    @CollectionTable(name = "movie_cast")
    private Set<String> movieCast;
    @NotBlank(message = "Please provide movie's release year!")
    private Integer releaseYear;
    @NotBlank(message = "Please provide movie's poster!")
    private String poster;
}
