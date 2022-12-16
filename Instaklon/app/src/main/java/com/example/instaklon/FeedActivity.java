package com.example.instaklon;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.google.firebase.auth.FirebaseAuth;

public class FeedActivity extends AppCompatActivity {
private FirebaseAuth auth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);
        auth=FirebaseAuth.getInstance();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {//menuyu feedactiviye baglıyoruz
        MenuInflater menuinflater=getMenuInflater();
        menuinflater.inflate(R.menu.option_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {//menude herhangi bir yer secilirse ne olacagını belirliyoruz
       if(item.getItemId()==R.id.add_post){
           Intent intentToUpload=new Intent(FeedActivity.this,UploadActivity.class);
           startActivity(intentToUpload);
           //upload activity
       }
else if (item.getItemId()==R.id.signout){
    auth.signOut();
    Intent intentToMain=new Intent(FeedActivity.this,MainActivity.class);
    startActivity(intentToMain);
    finish();
       }

        return super.onOptionsItemSelected(item);
    }
}