package com.example.sql;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListItem {
    Connection connect;
    String ConnectionResult = "";
    Boolean isSuucess = false;

    public List<Map<String, String>> getlist() {
        List<Map<String, String>> data = null;
        data = new ArrayList<Map<String, String>>();
        try {

            ConSQL conSQL = new ConSQL();
            connect = conSQL.conclass();
            if (connect != null) {
                String qu = "select * from DR";
                Statement statement = connect.createStatement();
                ResultSet resultSet = statement.executeQuery(qu);
                while(resultSet.next())
                {
                    Map<String, String> dtname = new HashMap<String, String>();
                    dtname.put("ID", resultSet.getString("ID"));
                    dtname.put("Name", resultSet.getString("Name"));
                    dtname.put("Year", resultSet.getString("Year_of_birth"));
                    data.add(dtname);
                }
                ConnectionResult = "success";
                isSuucess = true;
                connect.close();
            }else{
                ConnectionResult = "failed";
            }
        }catch (SQLException throwables)
        {
            throwables.printStackTrace();
        }
        return data;
    }
}
