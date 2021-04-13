package com.mycompany.database;
import java.util.HashMap;

public class PreparedQueries
{
    private HashMap<String, QueryElements> flagsSet;

    public PreparedQueries()
    {
        flagsSet = new HashMap<>();
        String[] buff0 = {">ANAAN",">NAFFO",">NNAVN",">NAHFN","<AAFVN",">AAHVO",">NAAFN",">NNHAO","<ANAAN","=NNAVN",">AAAFN","=ANHVO","=NNAAO",">ANHAO",">ANAFN",">NAHFO",">ANFFN","<NAHAO","<ANFVN","=AAHFN","=NNFVO","<ANFAO","=NAAFO","=AAAAN","=NAHFN","=NAAAN","=NNFAN","<NNFVO",">AAFAO","<NNHFN","<NAAVO","<NNAFN","=ANFFO","=ANAVO","=AAHFO","=AAHAO",">NAFAN","=ANAAO",">NAHVO","=ANAFN","<AAHFN","<AAFVO","=NAHVO","=NAFFN","<NAAFO","<NAFAO","=NAAVN","<NNAFO","=NNFFO","=AAFFO",">AAHVN",">ANFAN",">AAFVO",">NNHVO","=NNFAO","<NAFAN",">AAHFO",">NNHFN","=AAFFN","<NNAVN","<NAFFN",">AAAVO",">ANHAN","=NNAFN","=NAHAO",">NAAVO","<ANAVO","=ANHAN",">ANHFN","<ANAFN","=AAHVO","=AAFAN","=ANHVN","<NNHAN",">AAHFN","=NNAAN",">AAFFN","<ANHFN",">NAAAN","=ANFVO","<AAFAN",">ANFFO","=ANFFN",">NNAAO",">NAFVO",">AAFVN",">AAAVN",">ANFVO","<AAHVO",">NNHVN","=AAAFN","<AAHAO","<NAFFO","<NAAVN","<NNFAN","=AAAVN","<NNFVN","=ANFAO",">AAHAN","<AAAVN","<NAHVO","=AAAVO","<NAFVN",">NAFFN","<AAFFN","=NAHFO","<AAHFO","<ANHVO","=NAAAO",">NAFVN","=AAFVN","=AAFVO","<NNAVO",">NNAAN","=AAAFO","=NNHFO","<NNHVN","=ANAVN","<NAAFN","=ANHAO",">ANAVN","<ANFVO","=NAFFO",">AAFAN","=NNHVO","<AAFFO","=NNHAN","=ANHFO","=NNFFN",">NNHFO",">ANHVN","<NNHFO","=AAHVN",">ANAAO","<NAHFN","<AAAAN","<ANAVN",">ANFVN","=NAFAO","=NNAFO",">ANHFO",">AAHAO","<NNAAN","=ANAFO","<NNFAO",">NNFAN",">NAAFO",">AAAAO","=NNHAO",">NNAFN",">NAAAO","<ANHAN","=NAHAN",">NAHAO","=NNAVO","<ANAFO","<NAAAN","<NAAAO","=NNHVN",">ANAVO","<AAHAN",">ANFAO","<NAHFO",">NAAVN",">NNAFO","=NAFAN","=ANHFN","<AAAFN","<NNHVO","<NNFFO","<NNAAO",">ANHVO","<NAFVO","=AAFAO","<ANFAN","<NAHVN",">NNHAN","<ANFFO",">NNAVO",">NAHAN",">NNFAO","=NAAFN","<ANFFN",">AAAFO",">ANAFO","=NAHVN","<ANHFO",">NNFVN","<AAFAO","<ANAAO","=NAFVN","=NNFVN","=AAAAO",">NNFFN","=AAHAN",">NAHVN","<NNFFN","<AAAVO","=NNHFN","<AAHVN","<AAAFO",">NNFVO",">NNFFO",">AAAAN","<AAAAO","=ANFVN","=NAFVO","<NNHAO","<ANHAO",">AAFFO","<NAHAN","=NAAVO",">NAFAO","<ANHVN","=ANFAN","=ANAAN"};
        for (String s : buff0) {
            flagsSet.put(s, new QueryElements() );
        }
        generateSelectClause();
        generateWhereClause();
        generateFormaterWhere();
    }

    private void generateSelectClause()
    {
        QueryElements q;
        String[] buff0 = {"=AAHAN","=AAFAN","=AAAAN","=ANHAN","=ANFAN","=ANAAN","=NAHAN","=NAFAN","=NAAAN","=NNHAN","=NNFAN","=NNAAN","<AAHAN","<AAFAN","<AAAAN","<ANHAN","<ANFAN","<ANAAN","<NAHAN","<NAFAN","<NAAAN","<NNHAN","<NNFAN","<NNAAN",">AAHAN",">AAFAN",">AAAAN",">ANHAN",">ANFAN",">ANAAN",">NAHAN",">NAFAN",">NAAAN",">NNHAN",">NNFAN",">NNAAN"};
        for (String s : buff0) {
            q = flagsSet.get(s);
            q.selectClause = "SELECT r.epreuve_nom, r.epreuve_annee, r.epreuve_type, r.j1_nom, r.j1_prenom, r.j2_nom, r.j2_prenom";
            q.selectFormater = 5;
        }
        String[] buff1 = {"=AAHAO","=AAFAO","=AAAAO","=ANHAO","=ANFAO","=ANAAO","=NAHAO","=NAFAO","=NAAAO","=NNHAO","=NNFAO","=NNAAO","<AAHAO","<AAFAO","<AAAAO","<ANHAO","<ANFAO","<ANAAO","<NAHAO","<NAFAO","<NAAAO","<NNHAO","<NNFAO","<NNAAO",">AAHAO",">AAFAO",">AAAAO",">ANHAO",">ANFAO",">ANAAO",">NAHAO",">NAFAO",">NAAAO",">NNHAO",">NNFAO",">NNAAO"};
        for (String s : buff1) {
            q = flagsSet.get(s);
            q.selectClause = "SELECT r.epreuve_nom, r.epreuve_annee, r.epreuve_type, r.j1_nom, r.j1_prenom, r.j2_nom, r.j2_prenom, r.set1, r.set2, r.set3, r.set4, r.set5";
            q.selectFormater = 6;
        }
        String[] buff2 = {"=AAHVN","=AAFVN","=AAAVN","=ANHVN","=ANFVN","=ANAVN","=NAHVN","=NAFVN","=NAAVN","=NNHVN","=NNFVN","=NNAVN","<AAHVN","<AAFVN","<AAAVN","<ANHVN","<ANFVN","<ANAVN","<NAHVN","<NAFVN","<NAAVN","<NNHVN","<NNFVN","<NNAVN",">AAHVN",">AAFVN",">AAAVN",">ANHVN",">ANFVN",">ANAVN",">NAHVN",">NAFVN",">NAAVN",">NNHVN",">NNFVN",">NNAVN"};
        for (String s : buff2) {
            q = flagsSet.get(s);
            q.selectClause = "SELECT r.epreuve_nom, r.epreuve_annee, r.epreuve_type, r.j1_nom, r.j1_prenom";
            q.selectFormater = 1;
        }
        String[] buff3 = {"=AAHFN","=AAFFN","=AAAFN","=ANHFN","=ANFFN","=ANAFN","=NAHFN","=NAFFN","=NAAFN","=NNHFN","=NNFFN","=NNAFN","<AAHFN","<AAFFN","<AAAFN","<ANHFN","<ANFFN","<ANAFN","<NAHFN","<NAFFN","<NAAFN","<NNHFN","<NNFFN","<NNAFN",">AAHFN",">AAFFN",">AAAFN",">ANHFN",">ANFFN",">ANAFN",">NAHFN",">NAFFN",">NAAFN",">NNHFN",">NNFFN",">NNAFN"};
        for (String s : buff3) {
            q = flagsSet.get(s);
            q.selectClause = "SELECT r.epreuve_nom, r.epreuve_annee, r.epreuve_type, r.j2_nom, r.j2_prenom";
            q.selectFormater = 2;
        }
        String[] buff4 = {"=AAHVO","=AAFVO","=AAAVO","=ANHVO","=ANFVO","=ANAVO","=NAHVO","=NAFVO","=NAAVO","=NNHVO","=NNFVO","=NNAVO","<AAHVO","<AAFVO","<AAAVO","<ANHVO","<ANFVO","<ANAVO","<NAHVO","<NAFVO","<NAAVO","<NNHVO","<NNFVO","<NNAVO",">AAHVO",">AAFVO",">AAAVO",">ANHVO",">ANFVO",">ANAVO",">NAHVO",">NAFVO",">NAAVO",">NNHVO",">NNFVO",">NNAVO"};
        for (String s : buff4) {
            q = flagsSet.get(s);
            q.selectClause = "SELECT r.epreuve_nom, r.epreuve_annee, r.epreuve_type, r.j1_nom, r.j1_prenom, r.set1, r.set2, r.set3, r.set4, r.set5";
            q.selectFormater = 3;
        }
        String[] buff5 = {"=AAHFO","=AAFFO","=AAAFO","=ANHFO","=ANFFO","=ANAFO","=NAHFO","=NAFFO","=NAAFO","=NNHFO","=NNFFO","=NNAFO","<AAHFO","<AAFFO","<AAAFO","<ANHFO","<ANFFO","<ANAFO","<NAHFO","<NAFFO","<NAAFO","<NNHFO","<NNFFO","<NNAFO",">AAHFO",">AAFFO",">AAAFO",">ANHFO",">ANFFO",">ANAFO",">NAHFO",">NAFFO",">NAAFO",">NNHFO",">NNFFO",">NNAFO"};
        for (String s : buff5) {
            q = flagsSet.get(s);
            q.selectClause = "SELECT r.epreuve_nom, r.epreuve_annee, r.epreuve_type, r.j2_nom, r.j2_prenom, r.set1, r.set2, r.set3, r.set4, r.set5";
            q.selectFormater = 4;
        }
    }
    private void generateWhereClause()
    {
        QueryElements q;
        String[] buff0 = {"=NNHVO","=NNHVN","=NNHFO","=NNHFN","=NNHAO","=NNHAN","=NNFVO","=NNFVN","=NNFFO","=NNFFN","=NNFAO","=NNFAN"};
        for (String s : buff0) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee = ? AND r.epreuve_nom = ? AND r.epreuve_type = ?";
        }
        String[] buff1 = {"=NNAVO","=NNAVN","=NNAFO","=NNAFN","=NNAAO","=NNAAN"};
        for (String s : buff1) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee = ? AND r.epreuve_nom = ?";
        }
        String[] buff2 = {"=NAHVO","=NAHVN","=NAHFO","=NAHFN","=NAHAO","=NAHAN","=NAFVO","=NAFVN","=NAFFO","=NAFFN","=NAFAO","=NAFAN"};
        for (String s : buff2) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee = ? AND r.epreuve_type = ?";
        }
        String[] buff3 = {"=NAAVO","=NAAVN","=NAAFO","=NAAFN","=NAAAO","=NAAAN"};
        for (String s : buff3) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee = ?";
        }
        String[] buff4 = {"<NNHVO","<NNHVN","<NNHFO","<NNHFN","<NNHAO","<NNHAN","<NNFVO","<NNFVN","<NNFFO","<NNFFN","<NNFAO","<NNFAN"};
        for (String s : buff4) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee <= ? AND r.epreuve_nom = ? AND r.epreuve_type = ?";
        }
        String[] buff5 = {"<NNAVO","<NNAVN","<NNAFO","<NNAFN","<NNAAO","<NNAAN"};
        for (String s : buff5) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee <= ? AND r.epreuve_nom = ?";
        }
        String[] buff6 = {"<NAHVO","<NAHVN","<NAHFO","<NAHFN","<NAHAO","<NAHAN","<NAFVO","<NAFVN","<NAFFO","<NAFFN","<NAFAO","<NAFAN"};
        for (String s : buff6) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee <= ? AND r.epreuve_type = ?";
        }
        String[] buff7 = {"<NAAVO","<NAAVN","<NAAFO","<NAAFN","<NAAAO","<NAAAN"};
        for (String s : buff7) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee <= ?";
        }
        String[] buff8 = {">NNHVO",">NNHVN",">NNHFO",">NNHFN",">NNHAO",">NNHAN",">NNFVO",">NNFVN",">NNFFO",">NNFFN",">NNFAO",">NNFAN"};
        for (String s : buff8) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee >= ? AND r.epreuve_nom = ? AND r.epreuve_type = ?";
        }
        String[] buff9 = {">NNAVO",">NNAVN",">NNAFO",">NNAFN",">NNAAO",">NNAAN"};
        for (String s : buff9) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee >= ? AND r.epreuve_nom = ?";
        }
        String[] buff10 = {">NAHVO",">NAHVN",">NAHFO",">NAHFN",">NAHAO",">NAHAN",">NAFVO",">NAFVN",">NAFFO",">NAFFN",">NAFAO",">NAFAN"};
        for (String s : buff10) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee >= ? AND r.epreuve_type = ?";
        }
        String[] buff11 = {">NAAVO",">NAAVN",">NAAFO",">NAAFN",">NAAAO",">NAAAN"};
        for (String s : buff11) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_annee >= ?";
        }
        String[] buff12 = {"=ANHVO","=ANHVN","=ANHFO","=ANHFN","=ANHAO","=ANHAN","=ANFVO","=ANFVN","=ANFFO","=ANFFN","=ANFAO","=ANFAN","<ANHVO","<ANHVN","<ANHFO","<ANHFN","<ANHAO","<ANHAN","<ANFVO","<ANFVN","<ANFFO","<ANFFN","<ANFAO","<ANFAN",">ANHVO",">ANHVN",">ANHFO",">ANHFN",">ANHAO",">ANHAN",">ANFVO",">ANFVN",">ANFFO",">ANFFN",">ANFAO",">ANFAN"};
        for (String s : buff12) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_nom = ? AND r.epreuve_type = ?";
        }
        String[] buff13 = {"=ANAVO","=ANAVN","=ANAFO","=ANAFN","=ANAAO","=ANAAN","<ANAVO","<ANAVN","<ANAFO","<ANAFN","<ANAAO","<ANAAN",">ANAVO",">ANAVN",">ANAFO",">ANAFN",">ANAAO",">ANAAN"};
        for (String s : buff13) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_nom = ?";
        }
        String[] buff14 = {"=AAHVO","=AAHVN","=AAHFO","=AAHFN","=AAHAO","=AAHAN","=AAFVO","=AAFVN","=AAFFO","=AAFFN","=AAFAO","=AAFAN","<AAHVO","<AAHVN","<AAHFO","<AAHFN","<AAHAO","<AAHAN","<AAFVO","<AAFVN","<AAFFO","<AAFFN","<AAFAO","<AAFAN",">AAHVO",">AAHVN",">AAHFO",">AAHFN",">AAHAO",">AAHAN",">AAFVO",">AAFVN",">AAFFO",">AAFFN",">AAFAO",">AAFAN"};
        for (String s : buff14) {
            q = flagsSet.get(s);
            q.whereClause = "WHERE r.epreuve_type = ?";
        }
        String[] buff15 = {"<AAAFO",">AAAAO","<AAAVO","=AAAFO","<AAAVN","=AAAVO","<AAAFN",">AAAFO",">AAAVO","<AAAAO",">AAAVN","=AAAFN",">AAAFN","=AAAAO","=AAAAN","=AAAVN",">AAAAN","<AAAAN"};
        for (String s : buff15) {
            q = flagsSet.get(s);
            q.whereClause = "";
        }
    }
    private void generateFormaterWhere()
    {
        QueryElements q;
        String[] buff0 = {"=NNHVO","=NNHVN","=NNHFO","=NNHFN","=NNHAO","=NNHAN","=NNFVO","=NNFVN","=NNFFO","=NNFFN","=NNFAO","=NNFAN","<NNHVO","<NNHVN","<NNHFO","<NNHFN","<NNHAO","<NNHAN","<NNFVO","<NNFVN","<NNFFO","<NNFFN","<NNFAO","<NNFAN",">NNHVO",">NNHVN",">NNHFO",">NNHFN",">NNHAO",">NNHAN",">NNFVO",">NNFVN",">NNFFO",">NNFFN",">NNFAO",">NNFAN"};
        for (String s : buff0) {
            q = flagsSet.get(s);
            q.whereFormater = 7;
        }
        String[] buff1 = {"=NNAVO","=NNAVN","=NNAFO","=NNAFN","=NNAAO","=NNAAN","<NNAVO","<NNAVN","<NNAFO","<NNAFN","<NNAAO","<NNAAN",">NNAVO",">NNAVN",">NNAFO",">NNAFN",">NNAAO",">NNAAN"};
        for (String s : buff1) {
            q = flagsSet.get(s);
            q.whereFormater = 3;
        }
        String[] buff2 = {"=NAHVO","=NAHVN","=NAHFO","=NAHFN","=NAHAO","=NAHAN","=NAFVO","=NAFVN","=NAFFO","=NAFFN","=NAFAO","=NAFAN","<NAHVO","<NAHVN","<NAHFO","<NAHFN","<NAHAO","<NAHAN","<NAFVO","<NAFVN","<NAFFO","<NAFFN","<NAFAO","<NAFAN",">NAHVO",">NAHVN",">NAHFO",">NAHFN",">NAHAO",">NAHAN",">NAFVO",">NAFVN",">NAFFO",">NAFFN",">NAFAO",">NAFAN"};
        for (String s : buff2) {
            q = flagsSet.get(s);
            q.whereFormater = 5;
        }
        String[] buff3 = {"=ANHVO","=ANHVN","=ANHFO","=ANHFN","=ANHAO","=ANHAN","=ANFVO","=ANFVN","=ANFFO","=ANFFN","=ANFAO","=ANFAN","<ANHVO","<ANHVN","<ANHFO","<ANHFN","<ANHAO","<ANHAN","<ANFVO","<ANFVN","<ANFFO","<ANFFN","<ANFAO","<ANFAN",">ANHVO",">ANHVN",">ANHFO",">ANHFN",">ANHAO",">ANHAN",">ANFVO",">ANFVN",">ANFFO",">ANFFN",">ANFAO",">ANFAN"};
        for (String s : buff3) {
            q = flagsSet.get(s);
            q.whereFormater = 6;
        }
        String[] buff4 = {"=NAAVO","=NAAVN","=NAAFO","=NAAFN","=NAAAO","=NAAAN","<NAAVO","<NAAVN","<NAAFO","<NAAFN","<NAAAO","<NAAAN",">NAAVO",">NAAVN",">NAAFO",">NAAFN",">NAAAO",">NAAAN"};
        for (String s : buff4) {
            q = flagsSet.get(s);
            q.whereFormater = 1;
        }
        String[] buff5 = {"=ANAVO","=ANAVN","=ANAFO","=ANAFN","=ANAAO","=ANAAN","<ANAVO","<ANAVN","<ANAFO","<ANAFN","<ANAAO","<ANAAN",">ANAVO",">ANAVN",">ANAFO",">ANAFN",">ANAAO",">ANAAN"};
        for (String s : buff5) {
            q = flagsSet.get(s);
            q.whereFormater = 2;
        }
        String[] buff6 = {"=AAHVO","=AAHVN","=AAHFO","=AAHFN","=AAHAO","=AAHAN","=AAFVO","=AAFVN","=AAFFO","=AAFFN","=AAFAO","=AAFAN","<AAHVO","<AAHVN","<AAHFO","<AAHFN","<AAHAO","<AAHAN","<AAFVO","<AAFVN","<AAFFO","<AAFFN","<AAFAO","<AAFAN",">AAHVO",">AAHVN",">AAHFO",">AAHFN",">AAHAO",">AAHAN",">AAFVO",">AAFVN",">AAFFO",">AAFFN",">AAFAO",">AAFAN"};
        for (String s : buff6) {
            q = flagsSet.get(s);
            q.whereFormater = 4;
        }
        String[] buff7 = {"<AAAFO","=AAAVO","<AAAFN","=AAAAO",">AAAVO","<AAAAO","<AAAAN","=AAAVN","=AAAFO",">AAAFN",">AAAFO","<AAAVO","<AAAVN","=AAAFN",">AAAVN",">AAAAO",">AAAAN","=AAAAN"};
        for (String s : buff7) {
            q = flagsSet.get(s);
            q.whereFormater = 0;
        }
    }
    public QueryElements getQueryElement(String key)
    {
        return flagsSet.get(key);
    }
}
