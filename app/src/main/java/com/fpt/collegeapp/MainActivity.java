package com.fpt.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fpt.collegeapp.notice.UploadNotice;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice, addGalleryImage, addEBook;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uploadNotice = findViewById((R.id.addNotice));
        addGalleryImage = findViewById((R.id.uploadImage));
        addEBook = findViewById(R.id.addEbook);


        uploadNotice.setOnClickListener(this);
        addGalleryImage.setOnClickListener(this);
        addEBook.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        Intent intent;
        if(view.getId() == R.id.addNotice) {
            intent = new Intent(MainActivity.this, UploadNotice.class);
            startActivity(intent);
        } else if (view.getId() == R.id.uploadImage) {
            intent = new Intent(MainActivity.this, UploadImage.class);
            startActivity(intent);
        } else if (view.getId() == R.id.addEbook) {
            intent = new Intent(MainActivity.this, UploadPdfActivity.class);
            startActivity(intent);
        }

    }
}