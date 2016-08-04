package com.projects.irfan.letsbeginthegame;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * Created by Irfan on 23-06-2016.
 */
public class transactions extends Activity implements AdapterView.OnItemSelectedListener{
    int pos=-1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transactions);
        Spinner spinner=(Spinner)findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<String> myAdapter=
                new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,utilities.names);
        myAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(myAdapter);

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
/*
        String item = adapterView.getItemAtPosition(i).toString();

        // Showing selected spinner item
        Toast.makeText(adapterView.getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
*/
        pos=position;
        //Toast.makeText(getApplicationContext(),"Inside onItemSelected method",Toast.LENGTH_LONG).show();
        int j,k;
        /*for(k=0;k<utilities.names_size;k++){
            for(j=0;j<utilities.names_size;j++){
                Toast.makeText(getApplicationContext(),"utilities.matrix["+k+"]["+j+"] = "+utilities.matrix[k][j],
                        Toast.LENGTH_SHORT).show();
            }
        }*/

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
    public void gototransactionsagain(View v){
        EditText et=(EditText)findViewById(R.id.amount);


        if(et.getText().toString().length()<1){
            et.setError("Invalid amount!");
        }
        else {
            Toast.makeText(getApplicationContext(),"Added the transaction successfully",Toast.LENGTH_SHORT).show();
            double transactionAmount=Double.parseDouble(et.getText().toString());
            if(transactionAmount<=0){
                et.setError("Invalid amount!");
            }
            double perPerson = transactionAmount / utilities.names_size;
            int i, j;
            for (i = 0; i < utilities.names_size; i++) {
                for (j = 0; j < utilities.names_size; j++) {
                    if (i == j) {
                        utilities.matrix[i][j] += perPerson;
                    }
                    if (j == pos && i != j) {
                        utilities.matrix[i][j] -= perPerson;
                        utilities.matrix[j][i] += perPerson;
                    }
                }
            }
            perPerson = 0;
            et.setText("");
            //Initialize the spinner list to the default selection.
        /*int k;
        for(k=0;k<utilities.names_size;k++){
            for(j=0;j<utilities.names_size;j++){
                Toast.makeText(getApplicationContext(),"utilities.matrix["+k+"]["+j+"] = "+utilities.matrix[k][j],
                        Toast.LENGTH_SHORT).show();
            }
        }*/
        }

    }
    public void gotoviewdues(View v){
        //Toast.makeText(getApplicationContext(),"Before the creation of intent",Toast.LENGTH_LONG).show();
        EditText et=(EditText)findViewById(R.id.amount);

        if(et.getText().toString().length()>0) {
            double transactionAmount = Double.parseDouble(et.getText().toString());

            if (transactionAmount <= 0) {
                et.setError("Invalid amount!");
            } else {
                Toast.makeText(getApplicationContext(),"Added the transaction successfully",Toast.LENGTH_SHORT).show();
                double perPerson = transactionAmount / utilities.names_size;
                int i, j;
                for (i = 0; i < utilities.names_size; i++) {
                    for (j = 0; j < utilities.names_size; j++) {
                        if (i == j) {
                            utilities.matrix[i][j] += perPerson;
                        }
                        if (j == pos && i != j) {
                            utilities.matrix[i][j] -= perPerson;
                            utilities.matrix[j][i] += perPerson;
                        }
                    }
                }
                perPerson = 0;
                et.setText("");

            }
        }
        Intent i=new Intent();
        i.setComponent(new ComponentName(getApplicationContext(),dues.class));
        startActivity(i);
    }
}
