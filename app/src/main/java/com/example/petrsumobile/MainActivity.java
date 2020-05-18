package com.example.petrsumobile;

import android.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.Toolbar;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.example.petrsumobile.news.NewsFragment;
import com.example.petrsumobile.schedule.ScheduleFragment;
import com.example.petrsumobile.university.UniversityFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class MainActivity extends AppCompatActivity {

    //private ActionBar toolbar;
    //private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loadFragment(new NewsFragment());

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.navigation_news:
                        //Toast.makeText(MainActivity.this, "News", Toast.LENGTH_SHORT).show();
                        fragment = new NewsFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.navigation_schedule:
                        //Toast.makeText(MainActivity.this, "Schedule", Toast.LENGTH_SHORT).show();
                        fragment = new ScheduleFragment();
                        loadFragment(fragment);
                        break;
                    case R.id.navigation_university:
                        //Toast.makeText(MainActivity.this, "University", Toast.LENGTH_SHORT).show();
                        fragment = new UniversityFragment();
                        loadFragment(fragment);
                        break;
                }
                return true;
            }
        });
    }


    private void loadFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}

