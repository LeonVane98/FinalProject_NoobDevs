package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEstCadera1Binding

class EstCadera1 : Fragment() {

    private lateinit var fbinding: FragmentEstCadera1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentEstCadera1Binding.inflate(layoutInflater)
        navCad1()
        return fbinding.root
    }

    private fun navCad1(){
        fbinding.btnEstiramiento1.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estCadera1_to_estCadera2)
        }
    }
}