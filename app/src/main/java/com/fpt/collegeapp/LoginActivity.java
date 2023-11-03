package com.fpt.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginActivity extends AppCompatActivity {

    private DatabaseReference reference, databaseReference = null;
    private String username, password;
    private EditText usernameEdt, passwordEdt;
    private Button buttonLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        reference = FirebaseDatabase.getInstance("https://my-college-app-060102-default-rtdb.asia-southeast1.firebasedatabase.app/")
                                    .getReference().child("Users");

        usernameEdt = findViewById(R.id.username);
        passwordEdt = findViewById(R.id.password);


        buttonLogin = findViewById(R.id.buttonLogin);

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                startActivity(new Intent(LoginActivity.this, MainActivity.class));
//                startActivity(new Intent(LoginActivity.this, UserMainActivity.class));
                getUser();

            }
        });
    }

    private void getUser() {
        username = usernameEdt.getText().toString();
        password = passwordEdt.getText().toString();

        databaseReference = reference.child(username);

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserData user = snapshot.getValue(UserData.class);
                if (user != null) {
                    if (password.equals(user.getPassword())) {
                        Intent intent;
                        if (user.isAdmin()) {
                            intent = new Intent(LoginActivity.this, MainActivity.class);
                        } else {
                            intent = new Intent(LoginActivity.this, UserMainActivity.class);
                        }
                        startActivity(intent);
                    } else Toast.makeText(LoginActivity.this, "Wrong username or password", Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(LoginActivity.this, "User not found", Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(LoginActivity.this, "Something wrong", Toast.LENGTH_SHORT).show();
            }
        });
    }
}