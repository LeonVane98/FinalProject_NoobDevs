package com.example.traintrack

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.Navigation
import com.example.traintrack.databinding.FragmentLoginBinding
import com.example.traintrack.databinding.FragmentMenuBinding

class login : Fragment() {

    private lateinit var fbinding: FragmentLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fbinding = FragmentLoginBinding.inflate(layoutInflater)
        navLogin()
        return fbinding.root
    }

    private fun navLogin(){
        fbinding.btnInises.setOnClickListener {
            Navigation.findNavController(fbinding.root).navigate(R.id.action_login_to_menu2)
        }
    }

}




