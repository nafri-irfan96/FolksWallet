package com.projects.irfan.letsbeginthegame;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by Irfan on 21-06-2016.
 */
public class folksnames extends Activity {
    //utilities obj=new utilities();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.folksnames);
        EditText et=(EditText)findViewById(R.id.editText);
        et.setInputType(InputType.TYPE_CLASS_TEXT);

    }
    public void gototransactions(View v){
        EditText et = (EditText) findViewById(R.id.editText);
        if(et.getText().toString().length()!=0) {
            et.setInputType(InputType.TYPE_CLASS_TEXT);
            if (et.getText().toString().length() < 1) {
                et.setError("Enter a proper name");
            } else {
                utilities.names.add(et.getText().toString());
                utilities.names_size++;

                //EditText editText=(EditText)findViewById(R.id.editText);
                et.setText("");
                //Toast.makeText(getApplicationContext(),"Successfully added entry, size ="+obj.size,Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),"Name="+utilities.names.get(utilities.names_size-1)+" Size="+utilities.names_size,Toast.LENGTH_LONG).show();
                Toast.makeText(getApplicationContext(),"Added "+utilities.names.get(utilities.names_size-1)+" successfully",Toast.LENGTH_SHORT).show();
            }
        }
        utilities.matrix=new double[utilities.names_size][utilities.names_size];
        int k,j;
        for(k=0;k<utilities.names_size;k++){
            for(j=0;j<utilities.names_size;j++){
                utilities.matrix[k][j]=0;
                //Toast.makeText(getApplicationContext(),"utilities.matrix["+k+"]["+j+"] = "+utilities.matrix[k][j],Toast.LENGTH_SHORT).show();
            }
        }

        if(utilities.names_size>=2) {
            Intent i = new Intent();
            i.setComponent(new ComponentName(getApplicationContext(), transactions.class));
            startActivity(i);
        }
        else
            et.setError("Please enter one more name");

    }
    public void gotofolksnamesagain(View v) {
        /*Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(),folksnames.class));
        startActivity(i);*/

        EditText et = (EditText) findViewById(R.id.editText);
        et.setInputType(InputType.TYPE_CLASS_TEXT);
        if (et.getText().toString().length() < 1) {
            et.setError("Enter a proper name");
        } else {
            utilities.names.add(et.getText().toString());
            utilities.names_size++;

            //EditText editText=(EditText)findViewById(R.id.editText);
            et.setText("");
            //Toast.makeText(getApplicationContext(),"Successfully added entry, size ="+obj.size,Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(),"Name="+utilities.names.get(utilities.names_size-1)+" Size="+utilities.names_size,Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),"Added "+utilities.names.get(utilities.names_size-1)+" successfully",Toast.LENGTH_SHORT).show();
        }
    }
    public void gotoshowfolks(View v){
        //Toast.makeText(getApplicationContext(),"Clicked me!",Toast.LENGTH_LONG).show();
        EditText et = (EditText) findViewById(R.id.editText);
        if(et.getText().toString().length()!=0) {
            et.setInputType(InputType.TYPE_CLASS_TEXT);
            if (et.getText().toString().length() < 1) {
                et.setError("Enter a proper name");
            } else {
                utilities.names.add(et.getText().toString());
                utilities.names_size++;
                Toast.makeText(getApplicationContext(),"Added "+utilities.names.get(utilities.names_size-1)+" successfully",Toast.LENGTH_SHORT).show();
                //EditText editText=(EditText)findViewById(R.id.editText);
                et.setText("");
                //Toast.makeText(getApplicationContext(),"Successfully added entry, size ="+obj.size,Toast.LENGTH_LONG).show();
                //Toast.makeText(getApplicationContext(),"Name="+utilities.names.get(utilities.names_size-1)+" Size="+utilities.names_size,Toast.LENGTH_LONG).show();
            }
        }
        Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(),showfolks.class));
        startActivity(i);
    }

}
