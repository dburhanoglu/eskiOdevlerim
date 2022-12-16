package com.example.instaklon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.instaklon.databinding.ActivityMainBinding;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
private ActivityMainBinding binding;
    private Object View;
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        auth=FirebaseAuth.getInstance();
            FirebaseUser user= auth.getCurrentUser();

if(user!=null){
    Intent intent=new Intent(MainActivity.this,FeedActivity.class);
    startActivity(intent);
    finish();
}

    }
       public void signIClicked(android.view.View view){
String email=binding.emailtext.getText().toString();
String password=binding.passwordtext.getText().toString();
if(email.equals("")||password.equals("")){
    Toast.makeText(this,"enter email and password",Toast.LENGTH_LONG).show();
}
else{
    auth.signInWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
        @Override
        public void onSuccess(@NonNull AuthResult authResult) {
Intent intent=new Intent(MainActivity.this,FeedActivity.class);
startActivity(intent);
finish();



        }
    }).addOnFailureListener(new OnFailureListener() {
        @Override
        public void onFailure(@NonNull Exception e) {
    Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        }
    });
}

        }
        public void singUp(View view){
        String email=binding.emailtext.getText().toString();
            String password=binding.passwordtext.getText().toString();
            if(email.equals("")&& password.equals("")){
                Toast.makeText(this, "enter email or password", Toast.LENGTH_SHORT).show();
            }
            else{
                auth.createUserWithEmailAndPassword(email,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                    @Override
                    public void onSuccess(@NonNull AuthResult authResult) {
              Intent intent=new Intent(MainActivity.this,FeedActivity.class);
              startActivity(intent);
              finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(MainActivity.this,e.getLocalizedMessage(),Toast.LENGTH_LONG).show();

                    }
                });

            }

        }
    }