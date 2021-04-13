package com.mycompany.dao;

import com.mycompany.beans.Filtre;
import com.mycompany.beans.Joueur;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public abstract class TennisDaoBaseClass
{
    protected DaoFactory daoFactory;

    public TennisDaoBaseClass(DaoFactory daoFactory)
    {
        this.daoFactory = daoFactory;
    }

    protected void setFilter(PreparedStatement statement, Filtre f) throws SQLException
    {
        statement.setString(1, f.getTournoi() );
        statement.setString(2, f.getSexe() );
        statement.setString(3, f.getAnnee() );
    }

    protected void setJoueur(PreparedStatement statement, Joueur joueur) throws SQLException
    {
        statement.setString(1, joueur.getNom() );
        statement.setString(2, joueur.getPrenom() );
        statement.setString(3, joueur.getSexe() );
    }

    protected void setSearch(PreparedStatement statement, String searchQuery) throws SQLException
    {
        statement.setString(4, "%" + searchQuery + "%");
        statement.setString(5, "%" + searchQuery + "%");
        statement.setString(6, "%" + searchQuery + "%");
        statement.setString(7, "%" + searchQuery + "%");
    }
}
