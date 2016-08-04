package com.projects.irfan.letsbeginthegame;

import android.app.Activity;
import android.os.Bundle;
import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Irfan on 24-06-2016.
 */
public class dues extends Activity implements AdapterView.OnItemSelectedListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dues);
        Spinner spinner=(Spinner)findViewById(R.id.spinner2);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> myAdapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,utilities.names);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);


        //Toast.makeText(getApplicationContext(),"Inside dues class",Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int pos, long l) {
        String temporary=new String();
        TextView tv=(TextView)findViewById(R.id.duebox);
        int i=0;
        for(i=0;i<utilities.names_size;i++){
            if(i==pos){
                utilities.cumilative=utilities.matrix[pos][i];
                /*temporary=temporary+" "+"The Cumilative expenditure of "+utilities.names.get(i)+" is "+utilities.matrix[pos][i]+"\n";
                tv.setText(temporary);
                Toast.makeText(getApplicationContext(),temporary,Toast.LENGTH_SHORT).show();*/

            }
            if(utilities.matrix[pos][i]<0 && i != pos){
                temporary=temporary+" "+utilities.names.get(pos)+" needs to pay "+utilities.names.get(i)+
                        " an amount of "+(-1)*utilities.matrix[pos][i]+"\n";
                tv.setText(temporary);
                //Toast.makeText(getApplicationContext(),temporary,Toast.LENGTH_SHORT).show();
            }
            if(utilities.matrix[pos][i]>0 && i != pos){
                temporary=temporary+" "+utilities.names.get(pos)+" should receive "+utilities.matrix[pos][i]+" from "+utilities.names.get(i)+"\n";
                tv.setText(temporary);
                //Toast.makeText(getApplicationContext(),temporary,Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void gototransactionsagainfromdues(View v){
        finish();

    }
    public void gotosummary(View v){
        Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(),summary.class));
        startActivity(i);
    }
}
