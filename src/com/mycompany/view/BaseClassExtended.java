package com.mycompany.view;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Epreuve;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Match;

import javax.swing.*;
import java.util.List;

public abstract class BaseClassExtended<T> extends BaseClassView
{
    protected JComboBox filtreSexe;
    protected JComboBox filtreAnnee;
    protected JComboBox filtreTournoi;

    public BaseClassExtended(String[] columnNames)
    {
        super(columnNames);
    }

    public Filtre getFiltre()
    {
        try {
            Filtre f = Filtre.getInstance();
            f.setSexe(filtreSexe.getModel().getSelectedItem().toString());
            f.setAnnee(filtreAnnee.getModel().getSelectedItem().toString());
            f.setTournoi(filtreTournoi.getModel().getSelectedItem().toString());
            return f;
        } catch (BeanException err) {
            errorMessage(err.getMessage() );
            return null;
        }
    }

    public void setFiltre(Filtre f)
    {
        filtreSexe.setSelectedItem(f.getSexe());
        filtreAnnee.setSelectedItem(f.getAnnee());
        filtreTournoi.setSelectedItem(f.getTournoi());
    }

    public void updateTournois(List<String> tournois)
    {
        filtreTournoi.removeAllItems();
        filtreTournoi.addItem("Tous");
        for(String s : tournois){
            filtreTournoi.addItem(s);
        }
    }

    public void updateAnnees(List<String> annees)
    {
        filtreAnnee.removeAllItems();
        filtreAnnee.addItem("Toutes");
        for(String s : annees){
            filtreAnnee.addItem(s);
        }
    }
}
