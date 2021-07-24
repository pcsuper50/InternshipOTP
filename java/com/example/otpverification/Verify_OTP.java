package com.example.otpverification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AbsListView;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.jetbrains.annotations.NotNull;

import java.util.concurrent.TimeUnit;

public class Verify_OTP extends AppCompatActivity {

    AppCompatButton mVerify;
    TextView mtext,mResend;
    EditText ed1,ed2,ed3,ed4,ed5,ed6;
    String backotp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_otp);
        mVerify=findViewById(R.id.verify);
        ed1=findViewById(R.id.input1);
        ed2=findViewById(R.id.input2);
        ed3=findViewById(R.id.input3);
        ed4=findViewById(R.id.input4);
        ed5=findViewById(R.id.input5);
        ed6=findViewById(R.id.input6);
        mtext=findViewById(R.id.textmobile);
        mResend=findViewById(R.id.resend);


        mtext.setText(String.format("+91-%s",getIntent().getStringExtra("number")));
        backotp=getIntent().getStringExtra("backhandotp");



        mVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!ed1.getText().toString().trim().isEmpty() && !ed2.getText().toString().trim().isEmpty() &&
                        !ed3.getText().toString().trim().isEmpty() && !ed4.getText().toString().trim().isEmpty() &&
                        !ed5.getText().toString().trim().isEmpty() && !ed6.getText().toString().trim().isEmpty())
                {


                    String entercodeotp=ed1.getText().toString()+
                                        ed2.getText().toString()+
                                        ed3.getText().toString()+
                                        ed4.getText().toString()+
                                        ed5.getText().toString()+
                                        ed6.getText().toString();

                    if (backotp!=null)
                    {

                        PhoneAuthCredential phoneAuthCredential= PhoneAuthProvider.getCredential(backotp,entercodeotp);
                        FirebaseAuth.getInstance().signInWithCredential(phoneAuthCredential)
                                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                    @Override
                                    public void onComplete(@NonNull @NotNull Task<AuthResult> task)
                                    {
                                        if(task.isSuccessful())
                                        {
                                            Intent intent=new Intent(Verify_OTP.this,Select_Option.class);
                                            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                            startActivity(intent);
                                            Toast.makeText(Verify_OTP.this, "LogIn Successful", Toast.LENGTH_SHORT).show();
                                        }
                                        else
                                        {
                                            Toast.makeText(Verify_OTP.this, "Enter the Correct OTP", Toast.LENGTH_SHORT).show();
                                        }
                                    }
                                });

                    }
                    else
                    {
                        Toast.makeText(Verify_OTP.this, "Please Check Your Internet Connection", Toast.LENGTH_SHORT).show();
                    }

//                    Toast.makeText(Verify_OTP.this, "LogIN Suceessful", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(Verify_OTP.this, "Enter all number", Toast.LENGTH_SHORT).show();
                }
            }
        });


        numberotpmove();

        mResend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                PhoneAuthProvider.getInstance().verifyPhoneNumber(
                        "+91" + getIntent().getStringExtra("number"), 60,
                        TimeUnit.SECONDS,
                        Verify_OTP.this,
                        new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                            @Override
                            public void onVerificationCompleted(@NonNull @org.jetbrains.annotations.NotNull PhoneAuthCredential phoneAuthCredential)
                            {

                            }

                            @Override
                            public void onVerificationFailed(@NonNull @org.jetbrains.annotations.NotNull FirebaseException e)
                            {
                                Toast.makeText(Verify_OTP.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onCodeSent(@NonNull @NotNull String newbackhandotp, @NonNull @NotNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {

                                  backotp=newbackhandotp;
                                Toast.makeText(Verify_OTP.this, "OTP Resend Suceessfully", Toast.LENGTH_SHORT).show();

                            }
                        }

                );



            }
        });

    }

    private void numberotpmove() {

        ed1.addTextChangedListener(new TextWatcher() {
           @Override
           public void beforeTextChanged(CharSequence s, int start, int count, int after) {

           }

           @Override
           public void onTextChanged(CharSequence s, int start, int before, int count) {


               if(!s.toString().trim().isEmpty())
               {
                   ed2.requestFocus();
               }

           }

           @Override
           public void afterTextChanged(Editable s) {

           }
       });
        ed2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(!s.toString().trim().isEmpty())
                {
                    ed3.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(!s.toString().trim().isEmpty())
                {
                    ed4.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed4.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(!s.toString().trim().isEmpty())
                {
                    ed5.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        ed5.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {


                if(!s.toString().trim().isEmpty())
                {
                    ed6.requestFocus();
                }

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}