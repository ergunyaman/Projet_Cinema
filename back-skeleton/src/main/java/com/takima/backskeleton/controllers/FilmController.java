package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Film;
import com.takima.backskeleton.services.FilmService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/films")
@RequiredArgsConstructor
public class FilmController {
    private final FilmService filmService;

    @GetMapping("")
    public List<Film> listFilms() {
        return filmService.findAll();
    }

    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmService.findById(id);
    }

    @PostMapping("")
    public Film addFilm(@RequestBody Film film) {
        return filmService.save(film);
    }

    @PutMapping("/{id}")
    public Film updateFilm(@RequestBody Film film, @PathVariable Long id) {
        film.setId(id);
        return filmService.update(film);
    }

    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmService.deleteById(id);
    }

    @GetMapping("/search")
    public List<Film> searchFilmsByTitle(@RequestParam String titre) {
        return filmService.findByTitre(titre);
    }

    @GetMapping("/searchByGenre")
    public List<Film> searchFilmsByGenre(@RequestParam String genre) {
        return filmService.findByGenre(genre);
    }

    @GetMapping("/searchByRealisateurId")
    public List<Film> searchFilmsByRealisateurId(@RequestParam Long realisateurId) {
        return filmService.findByRealisateurId(realisateurId);
    }

    @GetMapping("/searchByDateRange")
    public List<Film> searchFilmsByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return filmService.findByDateBetween(startDate, endDate);
    }
}
