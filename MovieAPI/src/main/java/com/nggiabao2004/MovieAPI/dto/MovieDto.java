package com.nggiabao2004.MovieAPI.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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
    @NotBlank(message = "Please provide movie's studio!")
    private String studio;
    private Set<String> movieCast;
    @Pattern(regexp = "\\d{4}", message = "Release year must be 4 numbers!")
    private String releaseYear;
    @NotBlank(message = "Please provide movie's poster!")
    private String poster;
    @NotBlank(message = "Please provide movie's poster's url!")
    private String posterUrl;
}
