package com.mycompany.database;

public class QueryElements
{
    private final String baseQuery = """
        SELECT t.NOM as epreuve_nom, t.CODE as epreuve_code,
            EPREUVE.ANNEE as epreuve_annee, EPREUVE.TYPE_EPREUVE AS epreuve_type,
            j.NOM as j1_nom, j.PRENOM as j1_prenom, j.SEXE as j1_sexe,
            j2.NOM as j2_nom, j2.PRENOM as j2_prenom, j2.SEXE as j2_sexe,
            s.SET_1 as set1, s.SET_2 as set2, s.SET_3 as set3,
            s.SET_4 as set4, s.SET_5 as set5
        FROM EPREUVE
        JOIN TOURNOI as t ON ( t.ID = EPREUVE.ID_TOURNOI )
        JOIN MATCH_TENNIS as m ON ( m.ID_EPREUVE = EPREUVE.ID )
        JOIN JOUEUR as j ON ( j.ID = m.ID_VAINQUEUR )
        JOIN JOUEUR as j2 ON ( j2.ID = m.ID_FINALISTE )
        JOIN SCORE_VAINQUEUR as s ON ( s.ID_MATCH = m.ID )
    """;

    public String selectClause;
    public int selectFormater;
    public String whereClause;
    public int whereFormater;

    public String getQuery()
    {
        return selectClause  + " FROM (\n" + baseQuery + ") AS r " + whereClause + ";";
    }
    public int getWhereFormater()
    {
        return whereFormater;
    }
    public int getSelectFormater()
    {
        return selectFormater;
    }
}
