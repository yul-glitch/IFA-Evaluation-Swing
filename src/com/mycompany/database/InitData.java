package com.mycompany.database;

import java.sql.*;
import java.util.ArrayList;

public class InitData
{
    ArrayList<String> annees;
    ArrayList<String> tournois;

    public InitData(ResultSet annes, ResultSet tournois) throws SQLException
    {
        this.annees = new ArrayList<>();
        this.tournois = new ArrayList<>();

        annees.add("Toutes");
        while(annes.next() ) {
            Integer n = annes.getInt("ANNEE");
            this.annees.add(n.toString() );
        }
        this.tournois.add("Tous");
        while(tournois.next() ) {
            this.tournois.add(tournois.getString("NOM") );
        }
    }
    public String[] getAnnees()
    {
        return annees.toArray(new String[annees.size()] );
    }
    public String[] getTournois()
    {
        return tournois.toArray(new String[tournois.size()] );
    }
}
