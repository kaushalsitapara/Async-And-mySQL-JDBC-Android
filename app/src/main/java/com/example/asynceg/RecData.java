package com.example.asynceg;

import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SendData extends AsyncTask<String,String,String> {


    @Override
    protected String doInBackground(String... strings) {
        try {



            String classs = "com.mysql.jdbc.Driver";

            String url = "jdbc:mysql://192.168.43.57:3306/test";

            String un = "test";

            String password = "test";

            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();

            StrictMode.setThreadPolicy(policy);

            //Connection conn = null;
            // String ConnURL = null;


            Class.forName(classs).newInstance();

            Connection conn = DriverManager.getConnection(url, un, password);
            String username = MainActivity.sharedStrUser;
            String pwd = MainActivity.sharedStrPassword;
            String query = "insert into user values('" + username + "','" + pwd + "')";
            Statement stmt = conn.createStatement();

            stmt.executeUpdate(query);
           // System.out.println( username );


        } catch (IllegalAccessException e) {
            e.printStackTrace( );
        } catch (InstantiationException e) {
            e.printStackTrace( );
        } catch (SQLException e) {
            e.printStackTrace( );
        } catch (ClassNotFoundException e) {
            e.printStackTrace( );
        }


        return null;
    }

}
