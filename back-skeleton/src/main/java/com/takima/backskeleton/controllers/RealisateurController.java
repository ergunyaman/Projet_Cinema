package com.takima.backskeleton.controllers;

import com.takima.backskeleton.models.Realisateur;
import com.takima.backskeleton.services.RealisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/realisateurs")
@RequiredArgsConstructor
public class RealisateurController {
    private final RealisateurService realisateurService;

    @GetMapping("")
    public List<Realisateur> listRealisateurs() {
        return realisateurService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<Realisateur> getRealisateurById(@PathVariable Long id) {
        return realisateurService.findById(id);
    }

    @PostMapping("")
    public Realisateur addRealisateur(@RequestBody Realisateur realisateur) {
        return realisateurService.addRealisateur(realisateur);
    }

    @PutMapping("/{id}")
    public Realisateur updateRealisateur(@RequestBody Realisateur realisateur, @PathVariable Long id) {
        realisateur.setId(id);
        return realisateurService.updateRealisateur(realisateur);
    }

    @DeleteMapping("/{id}")
    public void deleteRealisateur(@PathVariable Long id) {
        realisateurService.deleteRealisateur(id);
    }

    @GetMapping("/searchByNationalite")
    public List<Realisateur> searchRealisateursByNationalite(@RequestParam String nationalite) {
        return realisateurService.findByNationalite(nationalite);
    }

    @GetMapping("/searchByNom")
    public List<Realisateur> searchRealisateursByNom(@RequestParam String nom) {
        return realisateurService.findByNom(nom);
    }

    @GetMapping("/searchByDateRange")
    public List<Realisateur> searchRealisateursByDateRange(@RequestParam Date startDate, @RequestParam Date endDate) {
        return realisateurService.findByDateBetween(startDate, endDate);
    }
}
