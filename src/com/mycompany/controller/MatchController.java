package com.mycompany.controller;

import com.mycompany.beans.Filtre;
import com.mycompany.beans.Match;
import com.mycompany.dao.*;
import com.mycompany.view.DocumentListenerCustom;
import com.mycompany.view.MatchView;

import java.awt.event.ActionEvent;
import java.util.List;

public class MatchController
{
    private MatchDao matchDao;
    private MatchView matchView;

    public MatchController(MatchView m)
    {
        matchView = m;
        matchDao = new MatchDaoImpl(DaoFactory.getInstance() );

        refresh();
        matchView.getFiltreSexe().addActionListener(e -> search());
        matchView.getFiltreAnnee().addActionListener(e -> search());
        matchView.getFiltreTournoi().addActionListener(e -> search());
        matchView.getSearchQuery().getDocument().addDocumentListener((DocumentListenerCustom) e -> search());
    }

    private void refresh()
    {
        try {
            matchView.updateTournois(matchDao.getTournois());
            matchView.updateAnnees(matchDao.getAnnees());
            matchView.updateTable(matchDao.lister());
            matchView.refreshColumnWidth();
        } catch (DaoException err) {
            matchView.errorMessage(err.getMessage());
        }
    }

    private void search()
    {
        try {
            Filtre f = matchView.getFiltre();
            List<Match> matchs = matchDao.rechercher(matchView.getSearchQuery().getText(), f);
            matchView.setFiltre(f);
            matchView.updateTable(matchs);
            matchView.refreshColumnWidth();
        } catch (DaoException err) {
            matchView.errorMessage(err.getMessage());
        }
    }

}
