package com.example.traintrack

import android.content.Context
import android.content.Intent
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.example.traintrack.complementos.CANT_PASOS
import com.example.traintrack.databinding.FragmentCaminataBinding
import com.example.traintrack.servicio.MiServicio
import com.example.traintrack.util.Constante



class Caminata : Fragment(), SensorEventListener {

    lateinit var fBinding: FragmentCaminataBinding
    private var running = false
    private var sensorManager: SensorManager? = null
    private var pasosTotales = 0f
    private var pasosPrevios = 0f


    override fun onResume() {
        super.onResume()
        running = true
        val stepSensor = sensorManager?.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

        sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
    }

    override fun onStop() {
        super.onStop()
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fBinding = FragmentCaminataBinding.inflate(inflater, container, false).apply {
            executePendingBindings()
        }


        sensorManager = requireContext().getSystemService(Context.SENSOR_SERVICE) as SensorManager
        return fBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        fBinding.barraDeProgreso.apply{
            setProgressWithAnimation(0f)
        }
        loadData()
        resetSteps()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun resetSteps() {
        fBinding.tvConteoPasos.setOnClickListener{
            pasosPrevios = pasosTotales
            fBinding.tvConteoPasos.text = "0"
            fBinding.barraDeProgreso.apply {
                setProgressWithAnimation(0f)
            }
            saveDate()
            true
        }
    }

    private fun saveDate() {
        Constante.editor(requireContext()).putFloat(CANT_PASOS, pasosPrevios).apply()
    }

    private fun loadData() {
        pasosPrevios = Constante.getSharePref(requireContext()).getFloat(CANT_PASOS, 0F)
    }

    override fun onSensorChanged(event: SensorEvent?) {
        if (running)
            pasosTotales = event!!.values[0]
        val pasosActuales = pasosTotales.toInt() - pasosPrevios.toInt()
        fBinding.tvConteoPasos.text = ("$pasosActuales")

        fBinding.barraDeProgreso.apply {
            setProgressWithAnimation(pasosActuales.toFloat())
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


}