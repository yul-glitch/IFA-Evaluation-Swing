package com.mycompany.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetEntry
{
    ArrayList<String> results;

    public ResultSetEntry()
    {
        results = new ArrayList<>();
    }
    public void updateBasics(ResultSet rs) throws SQLException
    {
        results.add(rs.getString("r.epreuve_nom") );
        Integer n = rs.getInt("r.epreuve_annee");
        results.add(n.toString() );
        results.add(rs.getString("r.epreuve_type") );
    }
    public void updateJ1(ResultSet rs) throws SQLException
    {
        String s = rs.getString("r.j1_nom");
        s += " " + rs.getString("r.j1_prenom");
        results.add(s);
    }
    public void updateJ2(ResultSet rs) throws SQLException
    {
        String s = rs.getString("r.j2_nom");
        s += " " + rs.getString("r.j2_prenom");
        results.add(s);
    }
    public void updateScore(ResultSet rs) throws SQLException
    {
        results.add(rs.getString("r.set1") );
        results.add(rs.getString("r.set2") );
        results.add(rs.getString("r.set3") );
        results.add(rs.getString("r.set4") );
        results.add(rs.getString("r.set5") );
    }
    public String[] getArray()
    {
        String[] arr = new String[results.size()];
        results.toArray(arr);
        return arr;
    }
    public String toString()
    {
        return results.toString();
    }
}