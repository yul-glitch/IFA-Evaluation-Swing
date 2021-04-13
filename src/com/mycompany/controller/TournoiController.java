package com.mycompany.controller;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Match;
import com.mycompany.beans.Tournoi;
import com.mycompany.dao.DaoException;
import com.mycompany.dao.DaoFactory;
import com.mycompany.dao.TournoiDao;
import com.mycompany.dao.TournoiDaoImpl;
import com.mycompany.view.DocumentListenerCustom;
import com.mycompany.view.TournoiView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class TournoiController
{
    private TournoiDao tournoiDao;
    private TournoiView tournoiView;

    public TournoiController(TournoiView j)
    {
        tournoiView = j;
        tournoiDao = new TournoiDaoImpl(DaoFactory.getInstance() );

        tournoiView.getButtonAjouter().addActionListener(e -> ajouterTournoi());
        tournoiView.getButtonModifier().addActionListener(e -> modifierTournoi());
        tournoiView.getButtonSupprimer().addActionListener(e -> supprimerTournoi());
        tournoiView.getButtonReset().addActionListener(e -> resetForm());
        tournoiView.getSearchQuery().getDocument().addDocumentListener((DocumentListenerCustom) e -> search());
        tournoiView.getTable().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me)
            {
                int row = tournoiView.getTable().getSelectedRow();
                //int column = tournoiView.getTable().getSelectedColumn();
                try {
                    long id = Long.parseLong((String) tournoiView.getTable().getValueAt(row, 0));
                    try {
                        tournoiView.updateForm(tournoiDao.lecture(id));
                    } catch (DaoException err) {
                        tournoiView.errorMessage(err.getMessage());
                    }
                } catch (ArrayIndexOutOfBoundsException err) {

                }
            }
        });
        refresh();
    }

    private void refresh()
    {
        try {
            List<Tournoi> tournois = tournoiDao.lister();
            tournoiView.updateTable(tournois);
        } catch (DaoException err) {
            tournoiView.errorMessage(err.getMessage());
        }
    }

    private void search()
    {
        try {
            List<Tournoi> tournois = tournoiDao.rechercher(tournoiView.getSearchQuery().getText());
            resetForm();
            tournoiView.updateTable(tournois);
        } catch (DaoException err) {
            tournoiView.errorMessage(err.getMessage());
        }
    }

    private void ajouterTournoi()
    {
        Tournoi tournoi = new Tournoi();
        try {
            tournoi.setId(-1);
            tournoiView.getForm(tournoi);
            tournoiDao.ajouter(tournoi);
            tournoiView.successMessage("Tournoi ajouté.");
            refresh();
        } catch (BeanException|DaoException err) {
            tournoiView.errorMessage(err.getMessage());
        }
    }

    private void modifierTournoi()
    {
        Tournoi tournoi = new Tournoi();
        tournoi.setId(tournoiView.getFieldId().getText());
        if (tournoi.getId() > -1) {
            try {
                tournoiView.getForm(tournoi);
                tournoiDao.modifier(tournoi);
                tournoiView.successMessage("Modification effectuée.");
                refresh();
            } catch (BeanException|DaoException err) {
                tournoiView.errorMessage(err.getMessage());
            }
        } else {
            tournoiView.errorMessage("Veuillez séléctionner un tournoi.");
        }
    }

    private void supprimerTournoi()
    {
        Tournoi tournoi = new Tournoi();
        tournoi.setId(tournoiView.getFieldId().getText());
        if (tournoi.getId() > -1) {
            try {
                tournoiDao.supprimer(tournoi.getId());
                tournoiView.successMessage("Tournoi supprimé.");
                refresh();
            } catch (DaoException err) {
                tournoiView.errorMessage(err.getMessage());
            }
        } else {
            tournoiView.errorMessage("Veuillez séléctionner un tournoi.");
        }
    }

    private void resetForm()
    {
        tournoiView.resetForm();
    }


}
