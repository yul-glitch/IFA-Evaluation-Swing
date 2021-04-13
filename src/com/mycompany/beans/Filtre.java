package com.mycompany.beans;


public class Filtre
{
    private String tournoi;
    private String annee;
    private String sexe;

    public Filtre() throws BeanException { }

    static public Filtre getInstance() throws BeanException
    {
        Filtre f = new Filtre();
        f.setTournoi(null);
        f.setAnnee(null);
        f.setSexe(null);
        return f;
    }

    public String getTournoi() {
        return tournoi;
    }

    public String getAnnee() {
        return annee;
    }

    public String getSexe() {
        return sexe;
    }

    public void setTournoi(String tournoi) throws BeanException
    {
        if (tournoi == null || tournoi.equals("Tous") ) {
            this.tournoi = "%";
            return;
        }

        String t = tournoi.toLowerCase();
        if (tournoi.length() > 20) {
            throw new BeanException("Nom du tournoi trop long, 20 charactères maximum.");
        } else if (t.contains("drop") || t.contains("insert") || t.contains("update") || t.contains("delete") || t.contains("truncate") ) {
            throw new BeanException("Bouuuuuuh");
        } else {
            this.tournoi = tournoi;
        }
    }

    public void setAnnee(String annee) throws BeanException
    {
        int a;
        if (annee == null || annee.equals("Toutes") ) {
            this.annee = "%";
            return;
        }
        try {
            a = Integer.parseInt(annee);
        } catch (java.lang.NumberFormatException e) {
            System.out.println(e);
            throw new BeanException("Format d'année invalide");
        }
        if (annee.length() != 4) {
            throw new BeanException("Format d'année invalide");
        } else if ((a < 2010) || (a > 2020)) {
            throw new BeanException("Format d'année invalide");
        } else {
            this.annee = annee;
        }
    }

    public void setSexe(String sexe) throws BeanException
    {
        if (sexe == null || sexe.equals("Les Deux") ) {
            this.sexe = "%";
            return;
        }
        if ( !(sexe.equals("Homme") || sexe.equals("Femme") ) ) {
            throw new BeanException("Choisissez entre 'Homme' et 'Femme'");
        } else {
            this.sexe = String.valueOf(sexe.charAt(0));
        }
    }

    @Override
    public String toString()
    {
        return "Filtre{" +
                "tournoi='" + tournoi + '\'' +
                ", annee='" + annee + '\'' +
                ", sexe='" + sexe + '\'' +
                '}';
    }
}
