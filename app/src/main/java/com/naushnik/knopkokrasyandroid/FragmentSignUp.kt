package com.naushnik.knopkokrasyandroid

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.naushnik.knopkokrasyandroid.databinding.FragmentSignUpBinding

class FragmentSignUp: Fragment() {
    private lateinit var binding: FragmentSignUpBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSignUpBinding.bind(view)

        binding.buttonSignUp.setOnClickListener{signUn()}
        binding.buttonHaveAcc.setOnClickListener{signIn()}

    }

    fun signUn(){
        val emailFragment = FragmentEmail()
        (activity as MainActivity).startFragment(emailFragment)
    }
    fun signIn(){
        val signInFragment = FragmentSignIn()
        (activity as MainActivity).startFragment(signInFragment)
    }
}