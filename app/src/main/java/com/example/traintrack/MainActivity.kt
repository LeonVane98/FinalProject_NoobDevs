package com.example.traintrack

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.traintrack.databinding.ActivityMainBinding
import com.example.traintrack.servicio.MiServicio


class MainActivity : AppCompatActivity() {

    private lateinit var fBinding: ActivityMainBinding

    override fun onResume() {
        stopService(Intent(this, MiServicio::class.java))
        super.onResume()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(fBinding.root)
    }

    override fun onStop() {
        ContextCompat.startForegroundService(this, Intent(this, MiServicio::class.java))
        super.onStop()
    }
}