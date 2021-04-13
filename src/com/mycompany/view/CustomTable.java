
package com.mycompany.view;

import javax.swing.table.AbstractTableModel;


class CustomTable extends AbstractTableModel
{
    private String[] columnNames;
    private Object[][] data;

    public CustomTable(String[] columnNames, Object[][] data)
    {
        this.columnNames = columnNames;
        this.data = data;
    }

    public int getColumnCount() { return columnNames.length; }

    public int getRowCount() { return data.length; }

    public String getColumnName(int col) { return columnNames[col]; }

    public Object getValueAt(int row, int col) { return data[row][col]; }

    public Class getColumnClass(int c) { return getValueAt(0, c).getClass(); }

    public boolean isCellEditable(int row, int col) { return false; }

    public void setValueAt(Object value, int row, int col)
    {
        data[row][col] = value;
        fireTableCellUpdated(row, col);
    }

}

