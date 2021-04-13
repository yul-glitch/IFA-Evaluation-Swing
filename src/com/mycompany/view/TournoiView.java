package com.mycompany.view;

import com.mycompany.beans.BeanException;
import com.mycompany.beans.Tournoi;

import javax.swing.*;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Font;


public class TournoiView extends BaseClassView<Tournoi>
{
    private JButton buttonAjouter;
    private JButton buttonModifier;
    private JButton buttonSupprimer;
    private JButton buttonReset;
    private JTextField fieldNom;
    private JTextField fieldCode;
    private JTextField fieldId;

    public TournoiView(String[] columnNames)
    {
        super(columnNames);
        GridBagConstraints c;

        c = setElement(2, 1, 0, 0);
        c.insets = new Insets(0,455,10,0);
        JLabel titre = new JLabel("Tournois");
        titre.setFont(new Font("Serif", Font.PLAIN, 40));
        add(titre, c);

        JPanel menu = new JPanel();
        menu.add(new JLabel("Rechercher:"));
        searchQuery = new JTextField();
        searchQuery.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        menu.add(searchQuery);

        c = setElement(2, 1, 0, 1);
        add(menu, c);

        JPanel interactive = new JPanel(new GridLayout(5, 1) );

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

        JPanel code = new JPanel();
        code.add(new JLabel("Code :  "));
        fieldCode = new JTextField();
        fieldCode.setPreferredSize(new Dimension(fieldWidth+20, fieldHeight) );
        code.add(fieldCode);
        interactive.add(code);

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

    public void updateForm(Tournoi tournoi)
    {
        fieldId.setText(Long.toString(tournoi.getId()));
        fieldNom.setText(tournoi.getNom());
        fieldCode.setText(tournoi.getCode());
    }

    public void getForm(Tournoi tournoi) throws BeanException
    {
        tournoi.setNom(fieldNom.getText() );
        tournoi.setCode(fieldCode.getText() );
    }

    public void resetForm()
    {
        fieldId.setText("");
        fieldNom.setText("");
        fieldCode.setText("");
    }

    public JButton getButtonAjouter() { return buttonAjouter; }
    public JButton getButtonModifier() { return buttonModifier; }
    public JButton getButtonSupprimer() { return buttonSupprimer; }
    public JButton getButtonReset() { return buttonReset; }
    public JTable getTable() { return table; }
    public JTextField getFieldId() { return fieldId; }
    public JTextField getSearchQuery() { return searchQuery; }
}
