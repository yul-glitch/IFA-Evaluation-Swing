package com.mycompany.database;
import java.util.HashMap;

public class QueryKey
{
    private HashMap<Integer, String> queryKey;

    public QueryKey()
    {
        queryKey = new HashMap<>();
        queryKey.put(0, "=");
        queryKey.put(1, "A");
        queryKey.put(2, "A");
        queryKey.put(3, "A");
        queryKey.put(4, "A");
        queryKey.put(5, "O");
    }
    public void update(int i, String value)
    {
        queryKey.put(i, value);
    }
    public String toString()
    {
        StringBuilder s = new StringBuilder();
        s.append(queryKey.get(0) );
        s.append(queryKey.get(1) );
        s.append(queryKey.get(2) );
        s.append(queryKey.get(3) );
        s.append(queryKey.get(4) );
        s.append(queryKey.get(5) );
        return s.toString();
    }
}
