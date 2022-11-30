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
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.traintrack.complementos.CANT_PASOS
import com.example.traintrack.databinding.FragmentCaminataBinding
import com.example.traintrack.servicio.MiServicio
import com.example.traintrack.util.Constante
import kotlinx.android.synthetic.main.fragment_caminata.*
import kotlin.math.round


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

        if (stepSensor == null) {
            Toast.makeText(
                this.activity,
                "No se ha detectado ningun sensor en este dispositivo",
                Toast.LENGTH_SHORT
            ).show()
        } else {
            sensorManager?.registerListener(this, stepSensor, SensorManager.SENSOR_DELAY_UI)
        }
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
        setMeta()
        super.onViewCreated(view, savedInstanceState)
    }

    private fun resetSteps() {
        fBinding.tvConteoPasos.setOnClickListener{
            pasosPrevios = pasosTotales
            fBinding.tvConteoPasos.text = "0"
            fBinding.tvDistancia.text = "0"
            fBinding.barraDeProgreso.apply {
                setProgressWithAnimation(0f)
            }
            saveDate()
            true
        }
    }

    private fun setMeta(){

        if(tvConteoTotal.text.isNotEmpty()){
            fBinding.btnMeta.setOnClickListener {
                fBinding.barraDeProgreso.progressMax = tvConteoTotal.text.toString().toFloat()
            }
        }else{
            Toast.makeText(this.requireContext(), "Ingresa una meta",
                Toast.LENGTH_SHORT).show()
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
        fBinding.tvDistancia.text = "${round(pasosActuales*0.762)} m"

        fBinding.barraDeProgreso.apply {
            setProgressWithAnimation(pasosActuales.toFloat())
        }
    }

    override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {
    }


}