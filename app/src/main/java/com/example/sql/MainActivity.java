package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class MainActivity extends AppCompatActivity {

    Connection connection;
    String ConnectionResult = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);}


            public void GetTextFromSQL(View v) {
                TextView ID = findViewById(R.id.ID);
                TextView Name = findViewById(R.id.Name);
                TextView Year = findViewById(R.id.Year);

                try {
                    ConSQL connectionHelper = new ConSQL();
                    connection = connectionHelper.conclass();
                    if (connection != null) {

                        String query = "Select * From DR";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(query);
                        while (resultSet.next()) {
                            ID.setText(resultSet.getString(1));
                            Name.setText(resultSet.getString(2));
                            Year.setText(resultSet.getString(3));
                        }
                    } else {
                        ConnectionResult = "Check Connection";
                    }
                } catch (Exception ex) {
                    Log.e("Error", ex.getMessage());
                }
            }
    }

