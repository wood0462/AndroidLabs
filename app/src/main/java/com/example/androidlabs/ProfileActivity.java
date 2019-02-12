package com.example.androidlabs;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.ImageButton;

public class ProfileActivity extends AppCompatActivity {
    EditText type;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    public static final String ACTIVITY_NAME = "PROFILE_ACTIVITY";
    ImageButton mImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        Intent in = getIntent();

        String em = in.getStringExtra("email");
        type = findViewById(R.id.email);
        type.setText(em);

        mImageButton = findViewById(R.id.picture);
        findViewById(R.id.picture).setOnClickListener( b -> {
            dispatchTakePictureIntent();
        });

        Log.e(ACTIVITY_NAME, "onCreate:");


        findViewById(R.id.butt2).setOnClickListener(b -> {

            Intent next = new Intent(this, ChatRoomActivity.class);
            startActivity(next);
        });

    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.e(ACTIVITY_NAME, "onPause:");
    }


    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageButton.setImageBitmap(imageBitmap);
            Log.e(ACTIVITY_NAME, "onActivityResult:");



        }
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.e(ACTIVITY_NAME, "OnDestroy:");


    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.e(ACTIVITY_NAME, "onResume:");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.e(ACTIVITY_NAME, "onStop:");

    }


}
