package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Seance;
import com.takima.backskeleton.services.SeanceService;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/seances")
@RequiredArgsConstructor
public class SeanceController {
    private final SeanceService seanceService;

    @GetMapping("")
    public List<Seance> listSeance(){
        return seanceService.findAll();
    }

    @GetMapping("/{id}")
    public Seance getSeanceById(@PathVariable Long id){
        return seanceService.findById(id);
    }

    @PostMapping("")
    public Seance addFilm(@RequestBody Seance seance){
        return seanceService.save(seance);
    }

    @PutMapping("/{id}")
    public Seance updateSeance(@RequestBody Seance seance, @PathVariable Long id){
        seance.setId(id);
        return seanceService.update(seance);
    }

    @DeleteMapping("/{id}")
    public void deleteSeance(@PathVariable Long id){
        seanceService.deleteById(id);
    }

    @GetMapping("/searchByDateRange")
    public List<Seance> searchFilmsByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return seanceService.findByDateBetween(startDate, endDate);
    }

}
