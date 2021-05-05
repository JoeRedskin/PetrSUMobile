package com.example.petrsumobile

//import com.example.petrsumobile.schedule.ScheduleFragment
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    //private ActionBar toolbar;
    //private Toolbar toolbar;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNavigationView = findViewById<View>(R.id.bottom_navigation) as BottomNavigationView
        val host = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = host.navController
        bottomNavigationView.setupWithNavController(navController)
    }
}