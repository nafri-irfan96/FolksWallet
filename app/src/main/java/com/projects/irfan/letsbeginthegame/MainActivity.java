package com.projects.irfan.letsbeginthegame;

import android.content.ComponentName;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void gotobasename(View v){
        Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(),basename.class));
        Intent j=new Intent();
        j.setComponent(new ComponentName(getApplicationContext(),folksnames.class));
        if(utilities.names_size==0) {
            startActivity(i);
        }
        else{
            startActivity(j);
        }
    }
}
