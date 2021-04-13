package com.mycompany.database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ResultSetFormat
{
    private ArrayList<String[]> results;
    private ArrayList<String> columnNames;
    private int selectFormater;

    public ResultSetFormat(ResultSet rs, int selectFormater) throws SQLException
    {
        results = new ArrayList<>();
        this.selectFormater = selectFormater;
        columnNames = new ArrayList<>();

        switch (this.selectFormater) {
            case 1:
                String[] columns0 = { "Tournoi", "Année", "Type", "Vainqueur" };
                for (String s : columns0) {
                    columnNames.add(s);
                }
                while (rs.next()) {
                    ResultSetEntry rse = new ResultSetEntry();
                    rse.updateBasics(rs);
                    rse.updateJ1(rs);
                    results.add(rse.getArray() );
                }
                break;
            case 2:
                String[] columns1 = { "Tournoi", "Année", "Type", "Finaliste" };
                for (String s : columns1) {
                    columnNames.add(s);
                }
                while (rs.next()) {
                    ResultSetEntry rse = new ResultSetEntry();
                    rse.updateBasics(rs);
                    rse.updateJ2(rs);
                    results.add(rse.getArray() );
                }
                break;
            case 3:
                String[] columns2 = { "Tournoi", "Année", "Type", "Vainqueur", "Set1", "Set2", "Set3", "Set4", "Set5" };
                for (String s : columns2) {
                    columnNames.add(s);
                }
                while (rs.next()) {
                    ResultSetEntry rse = new ResultSetEntry();
                    rse.updateBasics(rs);
                    rse.updateJ1(rs);
                    rse.updateScore(rs);
                    results.add(rse.getArray() );
                }
                break;
            case 4:
                String[] columns3 = { "Tournoi", "Année", "Type", "Finaliste", "Set1", "Set2", "Set3", "Set4", "Set5" };
                for (String s : columns3) {
                    columnNames.add(s);
                }
                while (rs.next()) {
                    ResultSetEntry rse = new ResultSetEntry();
                    rse.updateBasics(rs);
                    rse.updateJ2(rs);
                    rse.updateScore(rs);
                    results.add(rse.getArray() );
                }
                break;
            case 5:
                String[] columns4 = { "Tournoi", "Année", "Type", "Vainqueur", "Finaliste" };
                for (String s : columns4) {
                    columnNames.add(s);
                }
                while (rs.next()) {
                    ResultSetEntry rse = new ResultSetEntry();
                    rse.updateBasics(rs);
                    rse.updateJ1(rs);
                    rse.updateJ2(rs);
                    results.add(rse.getArray() );
                }
                break;
            case 6:
                String[] columns5 = { "Tournoi", "Année", "Type", "Vainqueur", "Finaliste", "Set1", "Set2", "Set3", "Set4", "Set5" };
                for (String s : columns5) {
                    columnNames.add(s);
                }

                while (rs.next() ) {
                    ResultSetEntry rse = new ResultSetEntry();
                    rse.updateBasics(rs);
                    rse.updateJ1(rs);
                    rse.updateJ2(rs);
                    rse.updateScore(rs);
                    results.add(rse.getArray() );
                }
                break;
        }
    }
    public String[][] getData()
    {
        String[][] arr = new String[results.size()][];
        results.toArray(arr);
        return arr;
    }
    public String[] getColumnNames()
    {
        String[] arr = new String[columnNames.size()];
        columnNames.toArray(arr);
        return arr;
    }
}