package com.mycompany.dao;

import com.mycompany.beans.Filtre;
import com.mycompany.beans.Joueur;

import java.util.List;

public interface JoueurDao
{
    Joueur lecture(Long id) throws DaoException;
    void ajouter(Joueur j) throws DaoException;
    void modifier(Joueur j) throws DaoException;
    void supprimer(Long id ) throws DaoException;
    List<Joueur> lister(Filtre f) throws DaoException;
    List<Joueur> rechercher(String chaine, Filtre f) throws DaoException;
}
