package com.projects.irfan.letsbeginthegame;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
/**
 * Created by Irfan on 23-06-2016.
 */
public class showfolks extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.showfolks);
        TextView tv=(TextView)findViewById(R.id.folk_name);
        String temp=new String();
        for(int i=0;i<utilities.names_size;i++){
            temp=temp+utilities.names.get(i)+"\n";
        }
        //temp=utilities.names.toString();
        tv.setText(temp);

        TextView tv2=(TextView)findViewById(R.id.size_id);
        //tv2.setText(utilities.names.size());
        //utilities obj=new utilities();
        tv2.setText((Integer.toString(utilities.names.size())));

    }
}
