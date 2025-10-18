package com.nggiabao2004.MovieAPI.services;

import com.nggiabao2004.MovieAPI.dto.MovieDto;
import com.nggiabao2004.MovieAPI.entities.Movie;
import com.nggiabao2004.MovieAPI.repositories.MovieRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final FileService fileService;

    public MovieServiceImpl(MovieRepository movieRepository, FileService fileService) {
        this.movieRepository = movieRepository;
        this.fileService = fileService;
    }

    @Value("${project-poster")
    private String path;

    @Value("${base.url}")
    private String baseUrl;

    @Override
    public MovieDto addMovie(MovieDto movieDto, MultipartFile file) throws IOException {
        // 1. Upload the file
        String uploadedFileName = fileService.uploadFiLe(path, file);
        // 2. Set the value of field 'poster' as filename
        movieDto.setPoster(uploadedFileName);
        //3. Map dto to Movie object
        Movie movie = new Movie(
            movieDto.getMovieId(),
            movieDto.getTitle(),
            movieDto.getDirector(),
            movieDto.getStudio(),
            movieDto.getMovieCast(),
            movieDto.getReleaseYear(),
            movieDto.getPoster()
        );
        //4. Save the movie object -> Saved Movie Object
        Movie savedMovie = movieRepository.save(movie);
        //5. Generate the posterUrl
        String posterUrl = baseUrl + "/file/" + uploadedFileName;
        //6. Map Movie Object to DTO object and return it
        MovieDto response = new MovieDto(
                savedMovie.getMovieId(),
                savedMovie.getTitle(),
                savedMovie.getDirector(),
                savedMovie.getStudio(),
                savedMovie.getMovieCast(),
                savedMovie.getReleaseYear(),
                savedMovie.getPoster(),
                posterUrl
        );
        return response;
    }

    @Override
    public MovieDto getMovie(Integer movieId) {
        return null;
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return List.of();
    }
}
