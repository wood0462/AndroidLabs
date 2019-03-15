package com.example.androidlabs;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class TestToolBar extends AppCompatActivity {
    private String dialog_text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tool_bar);
        Toolbar tbar = (Toolbar)findViewById(R.id.my_toolbar);
        setSupportActionBar(tbar);
        dialog_text = "This is the initial message";

    }

     @Override
    public boolean onCreateOptionsMenu(Menu menu){

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

    return true;

    }

    public boolean onOptionsItemSelected(MenuItem mi) {

        switch(mi.getItemId()) {
        case R.id.item1:

            Toast.makeText(this, dialog_text, Toast.LENGTH_SHORT).show();
            break;


        case R.id.item2:

            openDialog();
            break;

        case R.id.item3:

        Toolbar tbar = (Toolbar)findViewById(R.id.my_toolbar);
            setSupportActionBar(tbar);
            Snackbar sb = Snackbar.make(tbar, "Go Back", Snackbar.LENGTH_LONG)
                    .setAction("Go Back?", e->{finish();});

            sb.show();
            break;

        case R.id.over: {
            Toast.makeText(this, "You clicked overflow menu", Toast.LENGTH_LONG).show();
            break;
        }
    }
        return true;

    }

    public void openDialog(){


            View view = getLayoutInflater().inflate(R.layout.layout_dialog, null);
            TextView tv = (TextView) view.findViewById(R.id.type);
            EditText et = (EditText) view.findViewById(R.id.dialog_message);


            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setView(view)
                    .setPositiveButton("Positive", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                dialog_text = et.getText().toString();


                }
            })
                    .setNegativeButton("Negative", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    //this one should do nothing
                }
            }).setView(view);

                    builder.create().show();
        }


    @Override
    protected void onPause() {
        super.onPause();


    }

}

