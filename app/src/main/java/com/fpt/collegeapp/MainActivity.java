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

        uploadNotice = findViewById((R.id.addNotice));
        deleteNotice = findViewById((R.id.deleteNotice));


        uploadNotice.setOnClickListener(this);
        deleteNotice.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.addNotice) {
            Intent intent = new Intent(MainActivity.this, UploadNotice.class);
            startActivity(intent);
        }
        if(view.getId() == R.id.deleteNotice) {
            Intent intent = new Intent(MainActivity.this, DeleteNoticeActivity.class);
            startActivity(intent);
        }

    }
}