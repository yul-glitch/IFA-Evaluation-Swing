package com.mycompany.beans;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tournoi implements IBean
{
    private long id;
    private String nom;
    private String code;

    public Tournoi() { }

    public Tournoi(long id, String nom, String code)
    {
        this.id = id;
        this.nom = nom;
        this.code = code;
    }

    public Tournoi (ResultSet rs) throws SQLException
    {
        this.id = rs.getLong("id");
        this.nom = rs.getString("nom");
        this.code = rs.getString("code");
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

    public void setCode(String code) throws BeanException
    {
        if (code == null || code.length() == 0) {
            throw new BeanException("Nom trop court.");
        } else if (code.length() > 2) {
            throw new BeanException("Nom trop long, 2 charactères maximum.");
        } else {
            char[] charArray = code.toCharArray();
            for(int i=0; i < charArray.length; i++){
                if(!Character.isUpperCase( charArray[i]) ) {
                    throw new BeanException("CODE EN MAJUSCULES.");
                }
            }
            this.code = code;
        }
    }

    public long getId()
    {
        return id;
    }

    public String getNom()
    {
        return nom;
    }

    public String getCode()
    {
        return code;
    }

    @Override
    public String toString()
    {
        return "Tournoi{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
    public String[] toArray()
    {
        String[] arr = { Long.toString(getId()), getNom(), getCode() };
        return arr;
    }
}