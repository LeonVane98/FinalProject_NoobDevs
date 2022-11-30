package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEjerciciosBinding
import com.example.traintrack.databinding.FragmentEstiramientosBinding

class estiramientos : Fragment() {

    private lateinit var fbinding: FragmentEstiramientosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentEstiramientosBinding.inflate(layoutInflater)
        navEst()
        return fbinding.root
    }

    private fun navEst(){
        fbinding.btnEstiramientoCadera.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estiramientos_to_estCadera1)
        }

        fbinding.btnEstiramientoCuello.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estiramientos_to_estCuello1)
        }

        fbinding.btnEstiramientodeBicep.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estiramientos_to_estBicep1)
        }
    }


}