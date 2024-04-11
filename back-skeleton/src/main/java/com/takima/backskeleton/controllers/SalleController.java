package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Salle;
import com.takima.backskeleton.services.SalleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RequestMapping("/salles")
@RestController
@RequiredArgsConstructor
public class SalleController {
    private final SalleService salleService;

    @GetMapping("")
    public List<Salle> listSalle(){
        return salleService.findAll();
    }

    @GetMapping("/{id}")
    public Salle getSalleById(@PathVariable Long id){
        return salleService.findById(id);
    }

    @PostMapping("")
    public Salle addSalle(@RequestBody Salle salle){
        return salleService.save(salle);
    }
    @PutMapping("/{id}")
    public Salle updateFilm(@RequestBody Salle salle, @PathVariable Long id){
        salle.setId(id);
        return salleService.save(salle);
    }

    @DeleteMapping("/{id}")
    public void deleteSalle(@PathVariable Long id){
        salleService.deleteById(id);
    }




}
