package com.mycompany.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Joueur implements IBean
{
    private long id;
    private String prenom;
    private String nom;
    private String sexe;

    public Joueur() { }

    public Joueur (ResultSet rs) throws SQLException
    {
        id = rs.getLong("id");
        nom = rs.getString("nom");
        prenom = rs.getString("prenom");
        sexe = rs.getString("sexe");
    }

    public void setPrenom(String prenom) throws BeanException
    {
        if (prenom == null || prenom.length() == 0) {
            throw new BeanException("Prénom trop court.");
        } else if (prenom.length() > 20) {
            throw new BeanException("Prénom trop long, 20 charactères maximum.");
        } else {
            this.prenom = prenom;
        }
    }

    public void setNom(String nom) throws BeanException
    {
        if (nom == null || nom.length() == 0) {
            throw new BeanException("Nom trop court.");
        } else if (nom.length() > 20) {
            throw new BeanException("Nom trop long, 20 charactères maximum.");
        } else {
            this.nom = nom;
        }
    }

    public void setSexe(String sexe) throws BeanException
    {
        if (sexe == null || !(sexe.equals("H") || sexe.equals("F")) ) {
            throw new BeanException("Choisissez entre 'H' ou 'F'");
        } else {
            this.sexe = sexe;
        }
    }

    public void setId(long id)
    {
        this.id = id;
    }

    public void setId(String id)
    {
        try {
            this.id = Long.parseLong(id);
        } catch (NumberFormatException err) {
            this.id = -1;
        }
    }

    public String getPrenom()
    {
        return prenom;
    }

    public String getNom()
    {
        return nom;
    }

    public String getSexe()
    {
        return sexe;
    }

    public long getId()
    {
        return id;
    }

    @Override
    public String toString()
    {
        return "Joueur{" +
                "id=" + id +
                ", prenom='" + prenom + '\'' +
                ", nom='" + nom + '\'' +
                ", sexe='" + sexe + '\'' +
                '}';
    }

    public String[] toArray()
    {
        String[] arr = { Long.toString(getId()), getNom(), getPrenom(), getSexe() };
        return arr;
    }
}
