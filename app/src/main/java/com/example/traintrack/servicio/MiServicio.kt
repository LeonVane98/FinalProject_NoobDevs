package com.example.traintrack.servicio

import android.app.Service
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import android.os.IBinder
import android.util.Log
import androidx.annotation.RequiresApi
import com.example.traintrack.complementos.CANT_PASOS
import com.example.traintrack.util.Constante

class MiServicio: Service(), SensorEventListener {

    private var sensorManager: SensorManager? = null
    private var  running = false
    private var pasosTotales = 0f
    private var pasosPrevios = 0f
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int{
        try {
            running = true
            val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }catch (e: Exception){
            Log.e("WTF", e.message.toString())
        }
        return START_STICKY
    }
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onSensorChanged(event: SensorEvent?) {
        if (running)
            pasosTotales = event!!.values[0]
        val pasosActuales = pasosTotales.toInt() - pasosPrevios.toInt()
        Constante.editor(this).putFloat(CANT_PASOS, pasosPrevios).apply()
    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int) {
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }

    override fun stopService(name: Intent?): Boolean{
        return super.stopService(name)
    }

    override fun onDestroy() {
        val intent = Intent(this, Receptor::class.java)
        sendBroadcast(intent)
        super.onDestroy()
    }

}