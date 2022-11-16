package com.example.traintrack.servicio

import android.content.BroadcastReceiver
import android.content.Intent
import androidx.core.content.ContextCompat
import android.content.Context

class Receptor: BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        ContextCompat.startForegroundService(context!!, Intent(context, MiServicio::class.java))
    }
}