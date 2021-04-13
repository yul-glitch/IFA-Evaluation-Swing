package com.mycompany.dao;

import com.mycompany.beans.Tournoi;

import java.util.List;

public interface TournoiDao
{
    Tournoi lecture(Long id) throws DaoException;
    void ajouter(Tournoi t) throws DaoException;
    void modifier(Tournoi t) throws DaoException;
    void supprimer(Long id ) throws DaoException;
    List<Tournoi> lister() throws DaoException;
    List<Tournoi> rechercher(String chaine) throws DaoException;
}
