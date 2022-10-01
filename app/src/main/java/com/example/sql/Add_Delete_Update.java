package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Add_Delete_Update extends AppCompatActivity {
    Connection connection;
    String ConnectionResult = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_delete_update);
        TextView id = (TextView) findViewById(R.id.editTextID);
        TextView Name = (TextView) findViewById(R.id.textNAme);
        TextView Year = (TextView) findViewById(R.id.editTextTextPersonName3);
        Button btninsert = (Button) findViewById(R.id.btadd);
        Button btnupdate = (Button) findViewById(R.id.updatebt);
        Button btmdel  = (Button) findViewById(R.id.delete);

        btninsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConSQL connectionHelper = new ConSQL();
                connection = connectionHelper.conclass();
                try {
                    if (connection != null) {

                        String sqladd = "Insert into DR values ('" + id.getText().toString() + "','" + Name.getText().toString() + "','" + Year.getText().toString() + "')";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sqladd);
                    }
                } catch (Exception ex) {
                    Log.e("Error", ex.getMessage());
                }


            }
        });
       btnupdate.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               ConSQL connectionHelper = new ConSQL();
               connection = connectionHelper.conclass();
               try {
                   if (connection != null) {

                       String sqlupd = "update DR set  Name ='" + Name.getText().toString() + "', Year_of_birth ='" + Year.getText().toString() + "' where ID ='" + id.getText().toString() +"'";
                       Statement statement = connection.createStatement();
                       ResultSet resultSet = statement.executeQuery(sqlupd);
                   }
               } catch (Exception ex) {
                   Log.e("Error", ex.getMessage());
               }
           }
       });
        btmdel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ConSQL connectionHelper = new ConSQL();
                connection = connectionHelper.conclass();
                try {
                    if (connection != null) {

                        String sqldel = "DELETE DR WHERE ID ='" + id.getText().toString() + "'";
                        Statement statement = connection.createStatement();
                        ResultSet resultSet = statement.executeQuery(sqldel);
                    }
                } catch (Exception ex) {
                    Log.e("Error", ex.getMessage());
                }
            }
        });
    }


    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nazad:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }


}