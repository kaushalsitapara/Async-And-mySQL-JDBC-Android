package com.example.asynceg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    public static String sharedStrUser="";
    public static String sharedStrPassword="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt1=findViewById(R.id.bt1);



        bt1.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final EditText user = findViewById(R.id.txt1);
        final EditText password = findViewById(R.id.txt2);
        sharedStrPassword=password.getText().toString();
        sharedStrUser=user.getText().toString();
        SendData sd = new SendData();
        sd.execute();
        Intent I =new Intent(getApplicationContext(),Main2Activity.class);
        startActivity(I);

    }
}
