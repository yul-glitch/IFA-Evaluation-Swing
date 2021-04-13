package com.mycompany.view;


import com.mycompany.beans.IBean;

import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;


public abstract class BaseClassView<T extends IBean> extends JPanel
{
    protected String[] columnNames;
    protected JTable table;
    protected JScrollPane scrollPane;
    protected final int fieldWidth = 100;
    protected final int fieldHeight = 30;
    protected JTextField searchQuery;

    public BaseClassView(String[] columnNames)
    {
        super(new GridBagLayout());
        this.columnNames = columnNames;
        table = new JTable();
        table.setFillsViewportHeight(true);
        scrollPane = new JScrollPane(table);
        scrollPane.setPreferredSize(new Dimension(800, 300) );
    }

    protected GridBagConstraints setElement(int gridWhidth, int gridHeight, int x, int y)
    {
        GridBagConstraints c = new GridBagConstraints();
        c.gridwidth = gridWhidth;
        c.gridheight = gridHeight;
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = x;
        c.gridy = y;
        c.insets = new Insets(0, 0, 0, 0);
        return c;
    }

    public void errorMessage(String message)
    {
        JOptionPane.showMessageDialog(
            this,
            message, "Error",
            JOptionPane.PLAIN_MESSAGE
        );
    }

    public void successMessage(String message)
    {
        JOptionPane.showMessageDialog(
            this,
            message, "Succès",
            JOptionPane.PLAIN_MESSAGE
        );
    }
    public void updateTable(List<T> t)
    {
        String[][] data = new String[t.size()][columnNames.length];
        for (int i=0; i<t.size(); i++) {
            data[i] = t.get(i).toArray();
        }
        table.setModel(new DefaultTableModel(data, columnNames));
        table.getColumnModel().getColumn(0).setPreferredWidth(1);
    }
}
