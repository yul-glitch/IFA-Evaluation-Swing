package com.mycompany.dao;

import com.mycompany.beans.Epreuve;
import com.mycompany.beans.Filtre;
import java.util.List;

public interface EpreuveDao
{
    List<Epreuve> lister() throws DaoException;
    List<Epreuve> rechercher(Filtre f) throws DaoException;
    List<String> getAnnees() throws DaoException;
    List<String> getTournois() throws DaoException;
}
