package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEstCuello2Binding

class EstCuello2 : Fragment() {

    private lateinit var fbinding: FragmentEstCuello2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentEstCuello2Binding.inflate(layoutInflater)
        navCuello2()
        return fbinding.root
    }

    private fun navCuello2(){
        fbinding.btnEst2.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estCuello2_to_ejercicios)
        }
    }

}