package com.mycompany.dao;

import com.mycompany.beans.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EpreuveDaoImpl extends TennisDaoExtended implements EpreuveDao
{
    public EpreuveDaoImpl(DaoFactory daoFactory)
    {
        super(daoFactory);
        baseQuery = """        
        SELECT m.ID_EPREUVE as id, t.NOM as epreuve_nom, t.CODE as epreuve_code,
            EPREUVE.ANNEE as epreuve_annee, EPREUVE.TYPE_EPREUVE AS epreuve_type,
            s.SET_1 as set1, s.SET_2 as set2, s.SET_3 as set3, s.SET_4 as set4, s.SET_5 as set5
        FROM EPREUVE
        JOIN TOURNOI as t ON ( t.ID = EPREUVE.ID_TOURNOI )
        JOIN MATCH_TENNIS as m ON ( m.ID_EPREUVE = EPREUVE.ID )
        JOIN SCORE_VAINQUEUR as s ON ( s.ID_MATCH = m.ID )
        """;
    }

    @Override
    public List<Epreuve> lister() throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = baseQuery + " ORDER BY EPREUVE.ANNEE DESC;";
        List<Epreuve> epreuves = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();
            statement = connection.prepareStatement(sqlStr);
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                epreuves.add(new Epreuve(rs) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            throw new DaoException("Erreur de communication avec la Base de Données.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e);
                throw new DaoException("Erreur de communication avec la Base de Données.");
            }
        }
        return epreuves;
    }

    @Override
    public List<Epreuve> rechercher(Filtre f) throws DaoException
    {
        Connection connection = null;
        PreparedStatement statement = null;
        String sqlStr = baseQuery + """
        WHERE t.NOM LIKE ?
            AND EPREUVE.TYPE_EPREUVE LIKE ?
            AND CONVERT(EPREUVE.ANNEE, CHAR) LIKE ?
        ORDER BY EPREUVE.ANNEE DESC;
        """;
        List<Epreuve> epreuves = new ArrayList<>();

        try {
            connection = daoFactory.getConnection();

            statement = connection.prepareStatement(sqlStr);
            setFilter(statement, f);
            ResultSet rs = statement.executeQuery();
            while (rs.next() ) {
                epreuves.add(new Epreuve(rs) );
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println(e);
            throw new DaoException("Erreur de communication avec la Base de Données.");
        } finally {
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println(e);
                throw new DaoException("Erreur de communication avec la Base de Données.");
            }
        }
        return epreuves;
    }

}