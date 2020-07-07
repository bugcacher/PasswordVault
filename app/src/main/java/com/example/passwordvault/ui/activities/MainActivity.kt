package com.example.passwordvault.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.passwordvault.R
import com.example.passwordvault.databinding.ActivityMainBinding
import com.example.passwordvault.ui.fragments.AddCardDetails
import com.github.clans.fab.FloatingActionButton
import com.github.clans.fab.FloatingActionMenu
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding : ActivityMainBinding
    private lateinit var listener : NavController.OnDestinationChangedListener


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        navController = findNavController(R.id.fragment)
        NavigationUI.setupWithNavController(binding.navigationView,navController)
        appBarConfiguration = AppBarConfiguration(navController.graph,binding.drawerLayout)
        setupActionBarWithNavController(navController,appBarConfiguration)
        Navigation.setViewNavController(binding.cardsDetails,navController)


        setUpOnClickListeners()


    }

    private fun setUpOnClickListeners() {
        binding.cardsDetails.setOnClickListener {
            navController.navigate(R.id.action_global_addCardDetails)
            binding.floatingMenu.close(true)

        }

        binding.loginDetails.setOnClickListener {
            navController.navigate(R.id.action_global_addLoginDetails)
            binding.floatingMenu.close(true)

        }

        binding.bankDetails.setOnClickListener {
            navController.navigate(R.id.action_global_addBankDetails)
            binding.floatingMenu.close(true)

        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
    }
}
