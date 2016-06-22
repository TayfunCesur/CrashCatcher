package com.xionces.crashcatchersample;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by TayfunCesur on 22/06/16.
 */
public class Third  extends AppCompatActivity{

    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third);

        button = (Button) findViewById(R.id.thirdxxx);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a = null;
                String b = a.toString();
            }
        });



    }
}
