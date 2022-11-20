package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentLoginBinding
import com.example.traintrack.databinding.FragmentMenuBinding


class menu : Fragment() {


    private lateinit var fbinding: FragmentMenuBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentMenuBinding.inflate(layoutInflater)
        navLogin()
        return fbinding.root
    }

    private fun navLogin(){
        fbinding.btnEjercicios.setOnClickListener {
            Navigation.findNavController(fbinding.root).navigate(R.id.action_menu_to_ejercicios)
        }

        fbinding.btnProgreso.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_menu_to_progreso)
        }
    }
}