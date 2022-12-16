package com.example.logindeneme;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
EditText kullaniciAdi1,sifreKismi1;
Button girisYapbuton1;
DbHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        kullaniciAdi1=(EditText)findViewById(R.id.kullaniciAdi1);
        sifreKismi1=(EditText)findViewById(R.id.sifreKismi1);
        girisYapbuton1=(Button)findViewById(R.id.girisYapbuton1);
        DB=new DbHelper(this);


        girisYapbuton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String kullanici = kullaniciAdi1.getText().toString();
                String sifre = sifreKismi1.getText().toString();

                if(kullanici.equals("")||sifre.equals(""))
                    Toast.makeText(LoginActivity.this, "lütfen ilgili alanları giriniz", Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.checkusernamepassword(kullanici,sifre);
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this, "giriş başarılı", Toast.LENGTH_SHORT).show();
                        Intent intent  = new Intent(getApplicationContext(), HomeActivity.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(LoginActivity.this, "geçersiz bilgiler", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}