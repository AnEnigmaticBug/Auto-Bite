package com.bitecode.autobite.screens.shared.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.bitecode.autobite.R
import kotlinx.android.synthetic.main.act_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_main)

        bottomNavBNV.setupWithNavController(findNavController(R.id.navHostFRA))

        findNavController(R.id.navHostFRA).addOnDestinationChangedListener { _, destination, _ ->
            screenTitleLBL.text = when(destination.id) {
                R.id.wallet  -> "Wallet"
                R.id.history -> "History"
                else         -> throw IllegalStateException("Navigated to destination: ${destination.label}")
            }
        }
    }
}
