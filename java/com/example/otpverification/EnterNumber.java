package com.example.otpverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class EnterNumber extends AppCompatActivity {


    EditText mEdit1;
    AppCompatButton mBt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_number);

        mEdit1=findViewById(R.id.phonenumber);
        mBt1=findViewById(R.id.continu);

        mBt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mEdit1.getText().toString().trim().isEmpty())
                {
                    if(mEdit1.getText().toString().trim().length()==10)
                    {


                        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                                "+91" + mEdit1.getText().toString(), 60,
                                TimeUnit.SECONDS,
                                EnterNumber.this,
                                new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                                    @Override
                                    public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential)
                                    {

                                    }

                                    @Override
                                    public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e)
                                    {
                                        Toast.makeText(EnterNumber.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                                    }

                                    @Override
                                    public void onCodeSent(@NonNull @NotNull String backhandotp, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {


                                        Intent intent = new Intent(getApplicationContext(), Verify_OTP.class);
                                        intent.putExtra("number", mEdit1.getText().toString());
                                        intent.putExtra("backhandotp",backhandotp);

                                        startActivity(intent);

                                        mEdit1.setText(" ");

                                    }
                                }

                        );


//                        Intent intent=new Intent(getApplicationContext(),Verify_OTP.class);
//                        intent.putExtra("number",mEdit1.getText().toString());
//                        startActivity(intent);
                    }
                    else
                    {
                        Toast.makeText(EnterNumber.this, "Plaese Enter Correct umber", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(EnterNumber.this, "Enter Mobile Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}