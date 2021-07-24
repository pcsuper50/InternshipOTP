package com.example.otpverification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

public class Select_Option extends AppCompatActivity {

    RadioButton mRd1,mRd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_option);
        mRd1=findViewById(R.id.rd1);
        mRd2=findViewById(R.id.rd2);

        mRd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Option.this, "You Are a Shopper", Toast.LENGTH_SHORT).show();
            }
        });

        mRd2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(Select_Option.this, "You Are a Tranpotter", Toast.LENGTH_SHORT).show();
            }
        });



        Intent intent=new Intent(Select_Option.this,MainActivity.class);
        startActivity(intent);
    }
}