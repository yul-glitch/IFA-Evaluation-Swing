package com.mycompany.view;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Epreuve;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Match;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;


public class MatchView extends BaseClassExtended<Match> //BaseClassView<Match>
{
    public MatchView(String[] columnNames)
    {
        super(columnNames);
        GridBagConstraints c;

        c = setElement(2, 1, 0, 0);
        c.insets = new Insets(10,325,10,0);
        JLabel titre = new JLabel("Matchs");
        titre.setFont(new Font("Serif", Font.PLAIN, 40));
        add(titre, c);

        JPanel menu = new JPanel(new GridLayout(2, 4));
        menu.add(new JLabel("Sexe:"));
        menu.add(new JLabel("Année:"));
        menu.add(new JLabel("Tournoi:"));
        menu.add(new JLabel("Rechercher:"));

        String[] sexes = {"Les Deux", "Homme", "Femme"};
        filtreSexe = new JComboBox(sexes);
        filtreSexe.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        menu.add(filtreSexe);

        String[] annees = {"Toutes", };
        filtreAnnee = new JComboBox(annees);
        filtreAnnee.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        menu.add(filtreAnnee);

        String[] tournois = {"Tous", };
        filtreTournoi = new JComboBox(tournois);
        filtreTournoi.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        menu.add(filtreTournoi);

        searchQuery = new JTextField();
        searchQuery.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        menu.add(searchQuery);

        c = setElement(2, 1, 0, 1);
        c.insets = new Insets(0, 150, 0, 0);;
        add(menu, c);

        c = setElement(2, 1, 1, 2);
        add(scrollPane, c);
    }

    public void refreshColumnWidth()
    {
        table.getColumnModel().getColumn(2).setPreferredWidth(2);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(1);
    }

    public JTextField getSearchQuery() { return searchQuery; }
    public JComboBox getFiltreSexe() { return filtreSexe; }
    public JComboBox getFiltreAnnee() { return filtreAnnee; }
    public JComboBox getFiltreTournoi() { return filtreTournoi; }
}
