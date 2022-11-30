package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEstBicep1Binding
import com.example.traintrack.databinding.FragmentEstiramientosBinding

class EstBicep1 : Fragment() {

    private lateinit var fbinding: FragmentEstBicep1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentEstBicep1Binding.inflate(layoutInflater)
        navBicep1()
        return fbinding.root
    }

    private fun navBicep1(){
        fbinding.btnEjer1.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estBicep1_to_estBicep2)
        }
    }


}