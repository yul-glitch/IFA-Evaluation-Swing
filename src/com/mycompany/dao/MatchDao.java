package com.mycompany.dao;

import com.mycompany.beans.Filtre;
import com.mycompany.beans.Match;

import java.util.List;

public interface MatchDao
{
    List<Match> lister() throws DaoException;
    List<Match> rechercher(String chaine, Filtre f) throws DaoException;
    List<String> getAnnees() throws DaoException;
    List<String> getTournois() throws DaoException;
}
