package com.example.logindeneme;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ActionMenuItemView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
EditText kullaniciAdi,sifeKismi,sifreTekrar;
Button kayitOlbuton,girisYapbuton;
DbHelper DB;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        kullaniciAdi=(EditText) findViewById(R.id.kullaniciAdi);
        sifeKismi=(EditText) findViewById(R.id.sifreKismi);
        sifreTekrar=(EditText) findViewById(R.id.sifreTekrar);
        kayitOlbuton=(Button) findViewById(R.id.kayitOlbuton);
        girisYapbuton=(Button) findViewById(R.id.girisYapbuton);
        DB=new DbHelper(this);

        kayitOlbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String kullanici=kullaniciAdi.getText().toString();
                String sifre = sifeKismi.getText().toString();
                String tkrsifre = sifreTekrar.getText().toString();

                if(kullanici.equals("")||sifre.equals("")||tkrsifre.equals(""))
                    Toast.makeText(MainActivity.this, "lütfen biliglerinizi tekrar giriniz", Toast.LENGTH_SHORT).show();
                else{
                    if(sifre.equals(tkrsifre)){
                        Boolean checkuser = DB.checkusername(kullanici);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(kullanici,sifre);
                            if(insert==true){
                                Toast.makeText(MainActivity.this, "kayıt tamamlandı", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),HomeActivity.class);
startActivity(intent);

            }else{
                                Toast.makeText(MainActivity.this, "kayıt başarısız", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Bu kullanıcı zaten var.giris yapınız", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "şifre eşleşmiyor", Toast.LENGTH_SHORT).show();
                    }
                } }
        });

        girisYapbuton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
  Intent intent=new Intent(getApplicationContext(),LoginActivity.class);
  startActivity(intent);
            }
        });

    }
}