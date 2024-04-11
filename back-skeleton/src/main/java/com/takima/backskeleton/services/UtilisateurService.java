package com.takima.backskeleton.services;

import com.takima.backskeleton.DAO.*;
import com.takima.backskeleton.DTO.UtilisateurDto;
import com.takima.backskeleton.DTO.UtilisateurMapper;
import com.takima.backskeleton.models.Student;
import com.takima.backskeleton.models.Utilisateur;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class UtilisateurService {
    private final UtilisateurDao utilisateurDao;

    public List<Utilisateur> findAll() {
        Iterable<Utilisateur> it = utilisateurDao.findAll();
        List <Utilisateur> users = new ArrayList<>();
        it.forEach(users::add);
        return users ;
    }
    public Utilisateur getById(Long User_Id){return utilisateurDao.findById(User_Id).orElseThrow();}

    @Transactional
    public void deleteById(Long User_Id) {utilisateurDao.deleteById(User_Id);}

    @Transactional
    public void addUtilisateur(UtilisateurDto utilisateurDto) {
        Utilisateur utilisateur;
        try {
            utilisateur = UtilisateurMapper.fromDto(utilisateurDto, null);
        } catch (IOException e) {
            throw new RuntimeException("Error with utlisateur image", e);
        }

        utilisateurDao.save(utilisateur);
    }


    @Transactional
    public void updateUtilisateur(UtilisateurDto utilisateurDto,Long id){
        utilisateurDao.findById(id)
                .orElseThrow(() -> new NoSuchElementException("Student doesn't exist"));
        Utilisateur utilisateur;
        try {
            utilisateur = UtilisateurMapper.fromDto(utilisateurDto, id);
        } catch (IOException e) {
            throw new RuntimeException("Error with Student image", e);
        }
        utilisateurDao.save(utilisateur);
    }

    // peut etre modifié plus tard pour rechercher par séance etc
    public Utilisateur searchByUtilisateurId(Long User_Id) {
        return utilisateurDao.findByUtilisateurId(User_Id);
    }
}
