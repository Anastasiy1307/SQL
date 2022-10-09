package com.example.sql;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Connection connection;
    String ConnectionResult = "";
    SimpleAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.pereh:
                Intent intent = new Intent(this, Add_Delete_Update.class);
                startActivity(intent);
                break;
        }
    }

    public void GetListFromSQL(View v) {

        ListView lstv = (ListView) findViewById(R.id.List);
        List<Map<String, String>> Mydatalist = null;
        ListItem Mydata = new ListItem();
        Mydatalist = Mydata.getlist();

        String[] Fromw = {"ID", "Name", "Year"};
        int[] id = {R.id.ID, R.id.Name, R.id.Year};
        ad = new SimpleAdapter(MainActivity.this, Mydatalist, R.layout.listlayouttemplate, Fromw, id);
        lstv.setAdapter(ad);

        try {
            ConSQL connectionHelper = new ConSQL();
            connection = connectionHelper.conclass();
            if (connection != null) {

                String query = "Select * From DR";
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(query);
                while (resultSet.next()) {

                }
            } else {
                ConnectionResult = "Check Connection";
            }
        } catch (Exception ex) {
            Log.e("Error", ex.getMessage());
        }
    }
}