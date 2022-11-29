package com.example.traintrack

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.SensorManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.example.traintrack.databinding.ActivityMainBinding
import com.example.traintrack.servicio.MiServicio


class MainActivity : AppCompatActivity() {

    private lateinit var fBinding: ActivityMainBinding
    val ACTIVITY_RECOGNITION_CODE = 100
    private var sensorManager: SensorManager? = null

    override fun onResume() {
        stopService(Intent(this, MiServicio::class.java))
        super.onResume()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(fBinding.root)

        if (isPermissionGranted()) {
            requestPermission()
        }
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

    }

    override fun onStop() {
        ContextCompat.startForegroundService(this, Intent(this, MiServicio::class.java))
        super.onStop()
    }

    private fun requestPermission(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            ActivityCompat.requestPermissions(
                this,
                arrayOf(Manifest.permission.ACTIVITY_RECOGNITION),
                ACTIVITY_RECOGNITION_CODE
            )
        }
    }
    private fun isPermissionGranted(): Boolean{
        return ContextCompat.checkSelfPermission(
            this,
            Manifest.permission.ACTIVITY_RECOGNITION
        )!= PackageManager.PERMISSION_GRANTED
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode){
            ACTIVITY_RECOGNITION_CODE ->{
                if((grantResults.isNotEmpty() &&
                            grantResults[0] == PackageManager.PERMISSION_GRANTED)){

                }
            }
        }
    }
}