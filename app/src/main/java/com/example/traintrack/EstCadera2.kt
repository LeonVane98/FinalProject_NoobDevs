package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEstCadera2Binding

class EstCadera2 : Fragment() {

    private lateinit var fbinding: FragmentEstCadera2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentEstCadera2Binding.inflate(layoutInflater)
        navCad2()
        return fbinding.root
    }

    private fun navCad2(){
        fbinding.btnEstiramiento2.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estCadera2_to_ejercicios)
        }
    }

}