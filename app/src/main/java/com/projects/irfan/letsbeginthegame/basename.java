package com.projects.irfan.letsbeginthegame;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.InputType;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;
import android.view.KeyEvent;
import org.w3c.dom.Text;

import java.util.ArrayList;

/**
 * Created by Irfan on 21-06-2016.
 */
public class basename extends Activity{
    //utilities obj=new utilities();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.basename);

        EditText et=(EditText)findViewById(R.id.person1);
        et.setInputType(InputType.TYPE_CLASS_TEXT);


    }
    public void gotofolksnames(View v){
        //TextView tv=(TextView)findViewById(R.id.textView2);
        //ArrayList<String> list = new ArrayList<String>();
        //Toast.makeText(getApplicationContext(),tv.getText().toString(),Toast.LENGTH_LONG).show();
        //Toast.makeText(getApplicationContext(),et.getText().toString(),Toast.LENGTH_LONG).show();


        EditText et=(EditText)findViewById(R.id.person1);
        et.setInputType(InputType.TYPE_CLASS_TEXT);
        if(et.getText().toString().length()<1){
            et.setError("Enter a proper name");
        }
        else {

            utilities.names.add(et.getText().toString());
            utilities.names_size++;
            //Toast.makeText(getApplicationContext(),"Successfully added entry in base name, size ="+obj.size,Toast.LENGTH_LONG).show();
            //Toast.makeText(getApplicationContext(), "Name=" + utilities.names.get(utilities.names_size - 1) + "Size=" + utilities.names_size, Toast.LENGTH_LONG).show();
            Toast.makeText(getApplicationContext(),"Added "+utilities.names.get(utilities.names_size-1)+" successfully",Toast.LENGTH_SHORT).show();
            Intent i = new Intent();
            i.setComponent(new ComponentName(getApplicationContext(), folksnames.class));
            finish();
            startActivity(i);
        }
    }
}

