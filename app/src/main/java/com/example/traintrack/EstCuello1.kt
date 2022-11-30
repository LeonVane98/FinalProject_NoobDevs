package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEstCuello1Binding

class EstCuello1 : Fragment() {

    private lateinit var fbinding: FragmentEstCuello1Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentEstCuello1Binding.inflate(layoutInflater)
        navCuello1()
        return fbinding.root
    }

    private fun navCuello1(){
        fbinding.btnEst1.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estCuello1_to_estCuello2)
        }
    }

}