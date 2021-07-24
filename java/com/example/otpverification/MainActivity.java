package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {


    Spinner mSpinner;
    AppCompatButton mButton;


    String str[]={"English","Hindi","Chinese","Spanish","Arabic","Portuguese","Bengali","Russian",
            "Japanese","Lahnda(Western Punjab)"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mSpinner=findViewById(R.id.spinner);
        mButton=findViewById(R.id.next);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(MainActivity.this,
                android.R.layout.simple_list_item_1, str);

        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        mSpinner.setAdapter(adapter);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent=new Intent(MainActivity.this,EnterNumber.class);
                startActivity(intent);

            }
        });

    }
}