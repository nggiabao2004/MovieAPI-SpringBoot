package com.nggiabao2004.MovieAPI.repositories;

import com.nggiabao2004.MovieAPI.entities.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Integer> {
}
