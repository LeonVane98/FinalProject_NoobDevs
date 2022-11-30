package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentEstBicep2Binding

class EstBicep2 : Fragment() {

    private lateinit var fbinding: FragmentEstBicep2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fbinding = FragmentEstBicep2Binding.inflate(layoutInflater)
        navBicep2()
        return fbinding.root
    }

    private fun navBicep2(){
        fbinding.btnEjer2.setOnClickListener{
            Navigation.findNavController(fbinding.root).navigate(R.id.action_estBicep2_to_estBicep3)
        }
    }

}