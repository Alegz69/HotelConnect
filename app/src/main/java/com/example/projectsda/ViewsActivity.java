package com.example.projectsda;

import static com.example.projectsda.MainActivity.PREFS_NAME;
import static com.example.projectsda.MainActivity.PREF_EMAIL;
import static com.example.projectsda.MainActivity.PREF_PASSWORD;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.google.android.material.navigation.NavigationView;

import org.w3c.dom.Text;

import java.util.Objects;

public class ViewsActivity extends AppCompatActivity {



    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.views_activity);

        drawerLayout = findViewById(R.id.drawer_layout);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle("");

        actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        NavigationView navigationView = findViewById(R.id.nav_view);


        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        TextView textViewTitle = findViewById(R.id.TextViewTitle);
        textViewTitle.setText("Home");



        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        if (savedInstanceState == null) {
            HomeFragment homeFragment = new HomeFragment();
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.content_frame, homeFragment)
                    .commit();
        }


        navigationView.setNavigationItemSelectedListener(item -> {

            int itemId = item.getItemId();



            if (itemId == R.id.home ) {
                HomeFragment homeFragment = new HomeFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, homeFragment).commit();
                textViewTitle.setText("Home");
            }

            if (itemId == R.id.gallery) {

                GalleryFragment galleryFragment = new GalleryFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, galleryFragment).commit();
                textViewTitle.setText("Gallery");

            }
            if (itemId == R.id.contact)
            {
                ContactFragment contactFragment = new ContactFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.content_frame,contactFragment ).commit();
                textViewTitle.setText("Contact");
            }
            if(itemId == R.id.nav_logout)
                performLogout();



            drawerLayout.closeDrawers();
            return true;
        });

    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void performLogout() {



        clearCredentialsFromSharedPreferences();


        Intent loginIntent = new Intent(this, MainActivity.class);
        startActivity(loginIntent);
        finish();
    }

    private void clearCredentialsFromSharedPreferences() {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.remove(PREF_EMAIL);
        editor.remove(PREF_PASSWORD);
        editor.apply();
    }


}