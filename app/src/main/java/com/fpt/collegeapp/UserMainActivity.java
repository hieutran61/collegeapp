package com.fpt.collegeapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.fpt.collegeapp.ui.ebook.EbookActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class UserMainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
    private NavController navController;

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        navController = Navigation.findNavController(this, R.id.frame_layout);

        drawerLayout = findViewById(R.id.drawerLayout);
        navigationView = findViewById(R.id.navigation_view);

        toggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.start, R.string.close);

        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);

        navigationView.setNavigationItemSelectedListener(this);

        NavigationUI.setupWithNavController(bottomNavigationView, navController);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (toggle.onOptionsItemSelected(item)) {
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.navigation_developer) {
            Toast.makeText(this, "Developer", Toast.LENGTH_SHORT).show();
        } else if (item.getItemId() == R.id.navigation_video) {
            Toast.makeText(this, "navigation_video", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.navigation_rate) {
            Toast.makeText(this, "navigation_rate", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.navigation_ebook) {
            startActivity(new Intent(this, EbookActivity.class));

        } else if (item.getItemId() == R.id.navigation_website) {
            Toast.makeText(this, "navigation_website", Toast.LENGTH_SHORT).show();

        } else if (item.getItemId() == R.id.navigation_share) {
            Toast.makeText(this, "navigation_share", Toast.LENGTH_SHORT).show();
        }
        return true;
    }

    public ActionBarDrawerToggle getToggle() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }else {
            super.onBackPressed();
        }
        return toggle;
    }
}