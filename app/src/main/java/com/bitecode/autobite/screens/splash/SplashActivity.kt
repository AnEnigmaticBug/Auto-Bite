package com.bitecode.autobite.screens.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bitecode.autobite.R
import com.bitecode.autobite.screens.shared.view.MainActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.act_splash)

        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}