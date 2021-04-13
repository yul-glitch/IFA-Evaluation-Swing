package com.mycompany.beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

public class Epreuve implements IBean
{
    private long id;
    private String nom;
    private String code;
    private String annee;
    private String type;
    private int[] score = new int[5];

    public Epreuve() {}
    public Epreuve(ResultSet rs) throws SQLException
    {
        id = rs.getLong("id");
        nom = rs.getString("epreuve_nom");
        code = rs.getString("epreuve_code");
        annee = rs.getString("epreuve_annee");
        type = rs.getString("epreuve_type");
        for (int i=0; i<5; i++) {
            score[i] = rs.getInt("set" + (i + 1) );
        }
    }

    public long getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getCode() {
        return code;
    }

    public String getAnnee() {
        return annee;
    }

    public String getType() {
        return type;
    }

    public int[] getScore()
    {
        return score;
    }

    public void setScore(int[] score)
    {
        this.score = score;
    }

    public String scoreToString(int i)
    {
        return Integer.toString(getScore()[i]);
    }

    public String[] toArray()
    {
        String[] arr = {
                Long.toString(getId()),
                getNom(),
                getCode(),
                getAnnee(),
                getType(),
                scoreToString(0),
                scoreToString(1),
                scoreToString(2),
                scoreToString(3),
                scoreToString(4)
        };
        return arr;
    }

    @Override
    public String toString()
    {
        return "Epreuve{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                ", annee='" + annee + '\'' +
                ", type='" + type + '\'' +
                ", score=" + Arrays.toString(score) +
                '}';
    }
}
