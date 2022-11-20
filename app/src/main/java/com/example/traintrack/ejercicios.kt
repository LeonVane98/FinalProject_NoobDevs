package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEjerciciosBinding
import com.example.traintrack.databinding.FragmentLoginBinding

class ejercicios : Fragment() {
    private lateinit var fbinding: FragmentEjerciciosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEjerciciosBinding.inflate(layoutInflater)
        navLogin()
        return fbinding.root
    }

    private fun navLogin(){
        fbinding.btnOpCaminata.setOnClickListener {
            Navigation.findNavController(fbinding.root).navigate(R.id.action_ejercicios_to_caminata)
        }

        fbinding.btnOpEstiramientos.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_ejercicios_to_estiramientos)
        }
    }
}