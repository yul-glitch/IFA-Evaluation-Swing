package com.mycompany.view;

import com.mycompany.controller.EpreuveController;
import com.mycompany.controller.JoueurController;
import com.mycompany.controller.MatchController;
import com.mycompany.controller.TournoiController;

import javax.swing.*;
import java.awt.*;


public class MainWindow extends JFrame
{
    final private String[] columnNamesJoueur = { "#", "Nom", "Prenom", "Sexe" };
    final private String[] columnNamesTournoi = { "#", "Nom", "Code" };
    final private String[] columnNamesMatch = { "#", "Tournoi", "Code", "Année", "Type", "Vainqueur", "Finaliste" };
    final private String[] columnNamesEpreuve = { "#", "Tournoi", "Code", "Année", "Type", "Set1", "Set2", "Set3", "Set4", "Set5" };
    private Container pane;

    public MainWindow()
    {
        super("AppTennis");
        setLocationRelativeTo(null);
        setResizable(false);
        setSize(1280, 600);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pane = getContentPane();

        JTabbedPane tabbedPane = new JTabbedPane();

        JoueurView joueurView = new JoueurView(columnNamesJoueur);
        TournoiView tournoiView = new TournoiView(columnNamesTournoi);
        MatchView matchView = new MatchView(columnNamesMatch);
        EpreuveView epreuveView = new EpreuveView(columnNamesEpreuve);

        JoueurController joueurController = new JoueurController(joueurView);
        TournoiController tournoiController = new TournoiController(tournoiView);
        MatchController matchController = new MatchController(matchView);
        EpreuveController epreuveController = new EpreuveController(epreuveView);

        tabbedPane.addTab("Joueurs", joueurView);
        tabbedPane.addTab("Tournois", tournoiView);
        tabbedPane.addTab("Matchs", matchView);
        tabbedPane.addTab("Épreuves", epreuveView);
        pane.add(tabbedPane);

        pack();
        setVisible(true);
    }

    public static void main(String[] args)
    {
        MainWindow mainWindow = new MainWindow();
    }

}