package com.example.androidlabs;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    SharedPreferences sp;
    EditText type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_lab3);

       type = findViewById(R.id.email);
        sp = getSharedPreferences("pref", Context.MODE_PRIVATE);
        String sa = sp.getString("email", "");

        type.setText(sa);

        findViewById(R.id.butt).setOnClickListener( b -> {

            Intent in = new Intent(this, ProfileActivity.class);
            startActivity(in.putExtra("email", type.getText().toString()));

        });

    }

    @Override
    protected void onPause(){
        super.onPause();
            SharedPreferences.Editor spe = sp.edit();
            String tp = type.getText().toString();
            spe.putString("email", tp);

            spe.commit();



    }


}
