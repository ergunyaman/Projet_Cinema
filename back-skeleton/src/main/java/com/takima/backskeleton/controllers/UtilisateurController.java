package com.takima.backskeleton.controllers;


import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.Utilisateur;
import com.takima.backskeleton.DTO.UtilisateurDto;
import com.takima.backskeleton.services.UtilisateurService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;

@CrossOrigin
@RequestMapping("utilisateurs")
@RestController
@RequiredArgsConstructor
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @GetMapping("")
    public List<Utilisateur> listUtilisateurs(@RequestParam(required = false) Long User_Id) {
        if (User_Id != null) {
            List <Utilisateur> users = new ArrayList<>();
            users.add(utilisateurService.searchByUtilisateurId(User_Id));
            return users;
        }
        return utilisateurService.findAll();
    }
    @GetMapping("/{Id_User}")
    public Utilisateur getUtilisateurById(@PathVariable Long Id_User){
        return utilisateurService.getById(Id_User);
    }
    @DeleteMapping("/{Id_User}")
    public void deleteUtilisateur(@PathVariable Long Id_User) {
        utilisateurService.deleteById(Id_User);
    }

    @PostMapping("")
    public void addUtilisateur(@RequestBody UtilisateurDto utilisateurDto) {
        utilisateurService.addUtilisateur(utilisateurDto);
    }

    @PostMapping("/{id}")
    public void updateUtilisateur(@RequestBody UtilisateurDto utilisateurDto, @PathVariable Long id) {
        utilisateurService.updateUtilisateur(utilisateurDto, id);
    }


}