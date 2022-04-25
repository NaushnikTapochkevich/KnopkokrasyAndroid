package com.naushnik.knopkokrasyandroid

import android.R.attr.defaultValue
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.naushnik.knopkokrasyandroid.databinding.FragmentEmailBinding


class FragmentEmail : Fragment() {
    private lateinit var binding: FragmentEmailBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        return inflater.inflate(R.layout.fragment_email, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding = FragmentEmailBinding.bind(view)

        val bundle = this.arguments
        if (bundle != null) {
            val myEmail = bundle.getString("identifier")
            binding.textEmail.text = myEmail
        }
    }
}