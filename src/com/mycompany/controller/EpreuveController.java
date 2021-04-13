package com.mycompany.controller;

import com.mycompany.beans.Filtre;
import com.mycompany.beans.Epreuve;
import com.mycompany.dao.*;
import com.mycompany.view.EpreuveView;

import java.util.List;

public class EpreuveController
{
    private EpreuveDao epreuveDao;
    private EpreuveView epreuveView;

    public EpreuveController(EpreuveView ep)
    {
        epreuveView = ep;
        epreuveDao = new EpreuveDaoImpl(DaoFactory.getInstance() );

        refresh();
        epreuveView.getFiltreSexe().addActionListener(e -> search());
        epreuveView.getFiltreAnnee().addActionListener(e -> search());
        epreuveView.getFiltreTournoi().addActionListener(e -> search());
    }

    private void refresh()
    {
        try {
            epreuveView.updateTournois(epreuveDao.getTournois());
            epreuveView.updateAnnees(epreuveDao.getAnnees());
            epreuveView.updateTable(epreuveDao.lister());
            epreuveView.refreshColumnWidth();
        } catch (DaoException err) {
            epreuveView.errorMessage(err.getMessage());
        }
    }

    private void search()
    {
        try {
            Filtre f = epreuveView.getFiltre();
            List<Epreuve> epreuves = epreuveDao.rechercher(f);
            epreuveView.setFiltre(f);
            epreuveView.updateTable(epreuves);
            epreuveView.refreshColumnWidth();
        } catch (DaoException err) {
            epreuveView.errorMessage(err.getMessage());
        }
    }

}
