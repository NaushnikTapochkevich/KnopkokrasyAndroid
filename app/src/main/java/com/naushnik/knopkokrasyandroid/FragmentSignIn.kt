package com.naushnik.knopkokrasyandroid

import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.naushnik.knopkokrasyandroid.databinding.FragmentSignInBinding


class FragmentSignIn : Fragment() {

    private lateinit var binding: FragmentSignInBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_in, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentSignInBinding.bind(view)

        binding.buttonSignIn.setOnClickListener { validation() }
        binding.buttonSignUp.setOnClickListener { signUp() }
        binding.forgotPass.setOnClickListener { forgotPadd() }

    }

    fun validation() {
        val regexPass = Regex("[a-zA-z0-9]")
        val textPassword = binding.password.text.toString()
        val matchedPass = regexPass.containsMatchIn(textPassword)

        val emailText = binding.email
        val passwordText = binding.password

        val pattrn = (Patterns.EMAIL_ADDRESS.matcher(emailText.text).matches())
        when {
            ((pattrn) and (passwordText.length() >= 8) and (matchedPass)) -> {
                (activity as MainActivity).emailFinish(emailText.text.toString())
            }
            ((!pattrn) and ((passwordText.length() < 8) or (!matchedPass))) -> {
                binding.emailText.text = getString(R.string.login_error)
                binding.passwordText.text = getString(R.string.password_error)
            }
            (!pattrn) -> {
                binding.emailText.text = getString(R.string.login_error)
            }
            ((passwordText.length() < 8) or (!matchedPass)) -> {
                binding.passwordText.text = getString(R.string.password_error)
            }
        }
    }

    fun signUp() {
        val signUpFragment = FragmentSignUp()
        (activity as MainActivity).startFragment(signUpFragment)
    }

    fun forgotPadd() {
        val forgotPadd = ForgotPadd()
        (activity as MainActivity).startFragmentBack(forgotPadd)
    }
}