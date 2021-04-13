package com.mycompany.database;

import java.sql.*;
import java.util.HashMap;


public class DBHandling
{
    private Connection conn;
    private final PreparedQueries preparedQueries;
    String query;

    public DBHandling(Connection conn)
    {
        this.conn = conn;
        preparedQueries = new PreparedQueries();
    }

    public InitData getInitData() throws SQLException
    {
        String query = "SELECT DISTINCT(ANNEE) FROM EPREUVE ORDER BY ANNEE DESC;";
        PreparedStatement stmnt = conn.prepareStatement(query);
        ResultSet annee = stmnt.executeQuery();

        query = "SELECT NOM FROM TOURNOI ORDER BY NOM ASC;";
        stmnt = conn.prepareStatement(query);
        ResultSet tournois = stmnt.executeQuery();

        return new InitData(annee, tournois);
    }
    public ResultSetFormat getReqData(String key, HashMap<Integer, String> params) throws SQLException
    {
        QueryElements q = preparedQueries.getQueryElement(key);
        Integer formater = q.getWhereFormater();

        PreparedStatement stmnt = conn.prepareStatement(q.getQuery() );
        switch (formater) {
            case 1:
                stmnt.setInt(1, Integer.parseInt(params.get(1)) );
                break;
            case 2:
                stmnt.setString(1, params.get(2) );
                break;
            case 3:
                stmnt.setInt(1, Integer.parseInt(params.get(1)) );
                stmnt.setString(2, params.get(2) );
                break;
            case 4:
                stmnt.setString(1, params.get(4) );
                break;
            case 5:
                stmnt.setInt(1, Integer.parseInt(params.get(1)) );
                stmnt.setString(2, params.get(4) );
                break;
            case 6:
                stmnt.setString(1, params.get(2) );
                stmnt.setString(2, params.get(4) );
                break;
            case 7:
                stmnt.setInt(1, Integer.parseInt(params.get(1)) );
                stmnt.setString(2, params.get(2) );
                stmnt.setString(3, params.get(4) );
                break;
        }

        ResultSet rs = stmnt.executeQuery();
        ResultSetFormat result = new ResultSetFormat(rs, q.getSelectFormater() );
        return result;
    }
    public void getJoueurs() throws SQLException
    {
        String query = "SELECT JOUEUR.PRENOM, JOUEUR.NOM, JOUEUR.SEXE FROM JOUEUR ORDER BY JOUEUR.NOM;";
        PreparedStatement stmnt = conn.prepareStatement(query);
        ResultSet annee = stmnt.executeQuery();
        while (annee.next() ) {
            String s = annee.getString("JOUEUR.PRENOM") + annee.getString("JOUEUR.NOM") + annee.getString("JOUEUR.SEXE");
            System.out.println(s);
        }
    }

    public String debug()
    {
        return query;
    }
}