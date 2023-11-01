package com.fpt.collegeapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.fpt.collegeapp.notice.DeleteNoticeActivity;
import com.fpt.collegeapp.notice.UploadNotice;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    CardView uploadNotice, addGalleryImage, addEbook, faculty, deleteNotice;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        uploadNotice.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);
        addGalleryImage = findViewById((R.id.uploadImage));


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
        }
        if(view.getId() == R.id.deleteNotice) {
            intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
            startActivity(intent);
        }

    }
}