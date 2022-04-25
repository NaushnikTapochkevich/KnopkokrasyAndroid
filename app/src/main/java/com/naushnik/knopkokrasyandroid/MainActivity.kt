package com.naushnik.knopkokrasyandroid

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.naushnik.knopkokrasyandroid.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    val signInFragment = FragmentSignIn()
    val emailFragment = FragmentEmail()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        startFragment(signInFragment)

    }

    fun startFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment)
            .commit()
    }

    fun startFragmentBack(fragment: Fragment) {
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, fragment)
            .addToBackStack("fragment")
            .commit()
    }

    fun emailFinish(textEmail: String){
        val bundle = Bundle()
        bundle.putString("identifier", textEmail)

        emailFragment.setArguments(bundle)
        supportFragmentManager.beginTransaction().replace(R.id.fragment_container_view, emailFragment)
            .commit()
    }
}
