package com.asoom.repositoriesgit.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.asoom.repositoriesgit.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    lateinit var navHostFragment: NavHostFragment
    lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        navHostFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment

        navController = navHostFragment.navController

    }
}

