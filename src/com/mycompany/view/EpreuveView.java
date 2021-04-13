package com.mycompany.view;

import com.mycompany.beans.Epreuve;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;


public class EpreuveView extends BaseClassExtended<Epreuve>
{
    public EpreuveView(String[] columnNames)
    {
        super(columnNames);
        GridBagConstraints c;

        c = setElement(2, 1, 0, 0);
        c.insets = new Insets(20,300,5,0);
        JLabel titre = new JLabel("Épreuves");
        titre.setFont(new Font("Serif", Font.PLAIN, 40));
        add(titre, c);

        JPanel menu = new JPanel(new GridLayout(2, 3));
        menu.add(new JLabel("Sexe:"));
        menu.add(new JLabel("Année:"));
        menu.add(new JLabel("Tournoi:"));

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

        c = setElement(2, 1, 0, 1);
        c.insets = new Insets(0, 210, 0, 0);;
        add(menu, c);

        c = setElement(2, 1, 1, 2);
        add(scrollPane, c);
    }

    public void refreshColumnWidth()
    {
        table.getColumnModel().getColumn(2).setPreferredWidth(2);
        table.getColumnModel().getColumn(3).setPreferredWidth(5);
        table.getColumnModel().getColumn(4).setPreferredWidth(1);
        table.getColumnModel().getColumn(5).setPreferredWidth(1);
        table.getColumnModel().getColumn(6).setPreferredWidth(1);
        table.getColumnModel().getColumn(7).setPreferredWidth(1);
        table.getColumnModel().getColumn(8).setPreferredWidth(1);
        table.getColumnModel().getColumn(9).setPreferredWidth(1);

    }

    public JComboBox getFiltreSexe() { return filtreSexe; }
    public JComboBox getFiltreAnnee() { return filtreAnnee; }
    public JComboBox getFiltreTournoi() { return filtreTournoi; }
}
