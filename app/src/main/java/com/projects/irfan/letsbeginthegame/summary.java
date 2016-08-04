package com.projects.irfan.letsbeginthegame;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Float2;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Irfan on 24-06-2016.
 */
public class summary extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.summary);
        TextView tv=(TextView)findViewById(R.id.my_summary);
        tv.setText("The cumilative expenditure of each person is "+(float)(utilities.cumilative));
    }
    public void aboutDeveloper(View v){

        startActivity(new Intent().setComponent(new ComponentName(getApplicationContext(),aboutDeveloper.class)));

    }
}
