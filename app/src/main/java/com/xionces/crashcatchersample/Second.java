package com.xionces.crashcatchersample;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by TayfunCesur on 22/06/16.
 */
public class Second  extends AppCompatActivity{


    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);


        button = (Button) findViewById(R.id.secondxxx);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Second.this,Third.class));
                finish();
            }
        });




    }
}
