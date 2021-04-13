package com.mycompany.controller;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Joueur;
import com.mycompany.dao.DaoException;
import com.mycompany.dao.DaoFactory;
import com.mycompany.dao.JoueurDao;
import com.mycompany.dao.JoueurDaoImpl;
import com.mycompany.view.DocumentListenerCustom;
import com.mycompany.view.JoueurView;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

public class JoueurController
{
    private JoueurDao joueurDao;
    private JoueurView joueurView;

    public JoueurController(JoueurView j)
    {
        joueurView = j;
        joueurDao = new JoueurDaoImpl(DaoFactory.getInstance() );

        joueurView.getButtonAjouter().addActionListener(e -> ajouterJoueur());
        joueurView.getButtonModifier().addActionListener(e -> modifierJoueur());
        joueurView.getButtonSupprimer().addActionListener(e -> supprimerJoueur());
        joueurView.getButtonReset().addActionListener(e -> resetForm());
        joueurView.getFiltreSexe().addActionListener(e -> search());
        joueurView.getSearchQuery().getDocument().addDocumentListener((DocumentListenerCustom) e -> search());
        joueurView.getTable().addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent me)
            {
                int row = joueurView.getTable().getSelectedRow();
                //int column = joueurView.getTable().getSelectedColumn();
                try {
                    long id = Long.parseLong((String) joueurView.getTable().getValueAt(row, 0));
                    try {
                        joueurView.updateForm(joueurDao.lecture(id));
                    } catch (DaoException err) {
                        joueurView.errorMessage(err.getMessage());
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
            Filtre filtre = joueurView.getFiltre();
            List<Joueur> joueurs = joueurDao.lister(filtre);
            joueurView.updateTable(joueurs);
        } catch (DaoException err) {
            joueurView.errorMessage(err.getMessage());
        }
    }

    private void search()
    {
        try {
            Filtre filtre = joueurView.getFiltre();
            List<Joueur> joueurs = joueurDao.rechercher(joueurView.getSearchQuery().getText(), filtre);
            resetForm();
            joueurView.updateTable(joueurs);
        } catch (DaoException err) {
            joueurView.errorMessage(err.getMessage());
        }
    }

    private void ajouterJoueur()
    {
        Joueur joueur = new Joueur();
        try {
            joueur.setId(-1);
            joueurView.getForm(joueur);
            joueurDao.ajouter(joueur);
            joueurView.successMessage("Joueur ajouté.");
            refresh();
        } catch (BeanException|DaoException err) {
            joueurView.errorMessage(err.getMessage());
        }
    }

    private void modifierJoueur()
    {
        Joueur joueur = new Joueur();
        joueur.setId(joueurView.getFieldId().getText());
        if (joueur.getId() > -1) {
            try {
                joueurView.getForm(joueur);
                joueurDao.modifier(joueur);
                joueurView.successMessage("Modification effectuée.");
                refresh();
            } catch (BeanException|DaoException err) {
                joueurView.errorMessage(err.getMessage());
            }
        } else {
            joueurView.errorMessage("Veuillez séléctionner un joueur.");
        }
    }

    private void supprimerJoueur()
    {
        Joueur joueur = new Joueur();
        joueur.setId(joueurView.getFieldId().getText());
        if (joueur.getId() > -1) {
            try {
                joueurDao.supprimer(joueur.getId());
                joueurView.successMessage("Joueur supprimé.");
                refresh();
            } catch (DaoException err) {
                joueurView.errorMessage(err.getMessage());
            }
        } else {
            joueurView.errorMessage("Veuillez séléctionner un joueur.");
        }
    }

    private void resetForm()
    {
        joueurView.resetForm();
    }

}
