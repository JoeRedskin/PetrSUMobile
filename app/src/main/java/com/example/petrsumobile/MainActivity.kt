package com.example.petrsumobile

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.petrsumobile.news.NewsFragment
//import com.example.petrsumobile.schedule.ScheduleFragment
import com.example.petrsumobile.university.UniversityFragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //private ActionBar toolbar;
    //private Toolbar toolbar;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //loadFragment(new NewsFragment());
        loadFragment(NewsFragment())
        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            val fragment: Fragment
            when (menuItem.itemId) {
                R.id.navigation_news -> {
                    //Toast.makeText(MainActivity.this, "News", Toast.LENGTH_SHORT).show();
                    fragment = NewsFragment()
                    loadFragment(fragment)
                }
                R.id.navigation_schedule -> {
                    //Toast.makeText(MainActivity.this, "Schedule", Toast.LENGTH_SHORT).show();
//                    fragment = ScheduleFragment()
                    fragment = NewsFragment()
                    loadFragment(fragment)
                }
                R.id.navigation_university -> {
                    //Toast.makeText(MainActivity.this, "University", Toast.LENGTH_SHORT).show();
                    fragment = UniversityFragment()
                    loadFragment(fragment)
                }
            }
            true
        }
    }

    private fun loadFragment(fragment: Fragment) {
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }
}