package com.mycompany.view;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Filtre;
import com.mycompany.beans.Joueur;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;


public class JoueurView extends BaseClassView<Joueur>
{
    private JButton buttonAjouter;
    private JButton buttonModifier;
    private JButton buttonSupprimer;
    private JButton buttonReset;
    private JComboBox filtreSexe;
    private JTextField fieldNom;
    private JTextField fieldPrenom;
    private JTextField fieldId;
    private JTextField searchQuery;
    private JComboBox fieldSexe;


    public JoueurView(String[] columnNames)
    {
        super(columnNames);
        GridBagConstraints c;

        c = setElement(2, 1, 0, 0);
        c.insets = new Insets(0,455,10,0);
        JLabel titre = new JLabel("Joueurs");
        titre.setFont(new Font("Serif", Font.PLAIN, 40));
        add(titre, c);

        JPanel menu = new JPanel();
        menu.add(new JLabel("Sexe:"));
        String[] sexes = {"Les Deux", "Homme", "Femme"};
        filtreSexe = new JComboBox(sexes);
        menu.add(filtreSexe);
        menu.add(new JLabel("Rechercher:"));
        searchQuery = new JTextField();
        searchQuery.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        menu.add(searchQuery);

        c = setElement(2, 1, 0, 1);
        add(menu, c);

        JPanel interactive = new JPanel(new GridLayout(6, 1) );

        JPanel id = new JPanel();
        id.add(new JLabel("ID :       "));
        fieldId = new JTextField();
        fieldId.setEditable(false);
        fieldId.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        id.add(fieldId);
        interactive.add(id);

        JPanel nom = new JPanel();
        nom.add(new JLabel("Nom :   "));
        fieldNom = new JTextField();
        fieldNom.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        nom.add(fieldNom);
        interactive.add(nom);

        JPanel prenom = new JPanel();
        prenom.add(new JLabel("Prenom :"));
        fieldPrenom = new JTextField();
        fieldPrenom.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        prenom.add(fieldPrenom);
        interactive.add(prenom);

        JPanel sexe = new JPanel();
        sexe.add(new JLabel("Sexe: "));
        String[] arr = { "H", "F" };
        fieldSexe = new JComboBox(arr);
        sexe.add(fieldSexe);
        interactive.add(sexe);

        JPanel bouttons1 = new JPanel();
        buttonAjouter = new JButton("Ajouter");
        buttonAjouter.setPreferredSize(new Dimension(fieldWidth, fieldHeight) );
        bouttons1.add(buttonAjouter);
        buttonModifier = new JButton("Modifier");
        buttonModifier.setPreferredSize(new Dimension(fieldWidth, fieldHeight) );
        bouttons1.add(buttonModifier);
        interactive.add(bouttons1);

        JPanel bouttons2 = new JPanel();
        buttonSupprimer = new JButton("Supprimer");
        buttonSupprimer.setPreferredSize(new Dimension(fieldWidth, fieldHeight) );
        bouttons2.add(buttonSupprimer);
        buttonReset = new JButton("Reset");
        buttonReset.setPreferredSize(new Dimension(fieldWidth, fieldHeight) );
        bouttons2.add(buttonReset);
        interactive.add(bouttons2);

        c = setElement(1, 1, 1, 2);
        add(scrollPane, c);

        c = setElement(1, 1, 0, 2);
        add(interactive, c);
    }

    public void updateForm(Joueur joueur)
    {
        fieldId.setText(Long.toString(joueur.getId()));
        fieldNom.setText(joueur.getNom());
        fieldPrenom.setText(joueur.getPrenom());
        fieldSexe.getModel().setSelectedItem(joueur.getSexe());
    }

    public void getForm(Joueur joueur) throws BeanException
    {
        joueur.setNom(fieldNom.getText() );
        joueur.setPrenom(fieldPrenom.getText() );
        joueur.setSexe(fieldSexe.getModel().getSelectedItem().toString() );
    }

    public void resetForm()
    {
        fieldId.setText("");
        fieldNom.setText("");
        fieldPrenom.setText("");
        fieldSexe.getModel().setSelectedItem("");
    }

    public Filtre getFiltre()
    {
        try {
            Filtre filtre = Filtre.getInstance();
            filtre.setSexe(filtreSexe.getModel().getSelectedItem().toString());
            return filtre;
        } catch (BeanException err) {
            errorMessage(err.getMessage() );
            return null;
        }
    }

    public JButton getButtonAjouter() { return buttonAjouter; }
    public JButton getButtonModifier() { return buttonModifier; }
    public JButton getButtonSupprimer() { return buttonSupprimer; }
    public JButton getButtonReset() { return buttonReset; }
    public JTextField getFieldNom() { return fieldNom; }
    public JTextField getFieldPrenom() { return fieldPrenom; }
    public JComboBox getFieldSexe() { return fieldSexe; }
    public JTable getTable() { return table; }
    public JComboBox getFiltreSexe() { return filtreSexe; }
    public JTextField getFieldId() { return fieldId; }
    public JTextField getSearchQuery() { return searchQuery; }
}
