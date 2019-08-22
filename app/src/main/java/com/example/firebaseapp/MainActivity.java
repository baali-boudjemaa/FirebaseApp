package com.example.firebaseapp;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    Button reg;
    EditText pass,email;
    TextView txt;
    ProgressDialog pb;
    FirebaseAuth fbauth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        reg=(Button)findViewById(R.id.Reg);
        pass=(EditText)findViewById(R.id.pass);
        email=(EditText)findViewById(R.id.email1);
        txt=(TextView) findViewById(R.id.textView);
        pb=new ProgressDialog(this);
        FirebaseApp.initializeApp(MainActivity.this);
        fbauth= FirebaseAuth.getInstance();

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setOnclicka();

            }
        });

    }
    void setOnclicka(){
        String eml=email.getText().toString().trim();
        String psss=pass.getText().toString().trim();
        if(TextUtils.isEmpty(eml)){

        }
        if(TextUtils.isEmpty(psss)){

        }
        pb.setMessage("connect .....");
        pb.show();
        fbauth.createUserWithEmailAndPassword(eml,psss)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this,"Successful",Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(MainActivity.this,"failure",Toast.LENGTH_SHORT).show();

                        }

                    }
                });

    }
}
