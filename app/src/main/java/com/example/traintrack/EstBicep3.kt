package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEstBicep3Binding

class EstBicep3 : Fragment() {

    private lateinit var fbinding: FragmentEstBicep3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        fbinding = FragmentEstBicep3Binding.inflate(layoutInflater)
        navBicep3()
        return fbinding.root
    }

    private fun navBicep3(){
        fbinding.btnEjer3.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estBicep3_to_ejercicios)
        }
    }
}