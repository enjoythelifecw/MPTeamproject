package com.example.teamprojectlogin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class NavigationDrawer : AppCompatActivity() {

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var navigationView: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.navigation_drawer)

        Log.d("IISE","drawer create")

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        Log.d("IISE","toolbar0")
        if (toolbar != null) {
            Log.d("IISE","toolbar1")
            setSupportActionBar(toolbar)
        } else {
            Log.d("IISE","toolbar2")
        }
        Log.d("IISE","toolbar2")


        drawerLayout = findViewById(R.id.drawer_layout)
        navigationView = findViewById(R.id.navigation_view)

        Log.d("IISE","drawer_layout, navigation view ")


        val toggle = ActionBarDrawerToggle(
            this,
            drawerLayout,
//            toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        Log.d("IISE","toggle")

    }

    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }
}
