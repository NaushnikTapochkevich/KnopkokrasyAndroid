package com.naushnik.knopkokrasyandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //инициализируем вьюшки
        val username: EditText = findViewById(R.id.edit_user)
        val password: EditText = findViewById(R.id.edit_password)
        val btnAuthorization: Button = findViewById(R.id.button_login)
        val textError: TextView = findViewById(R.id.text)

        btnAuthorization.setOnClickListener {

            val intent = Intent(this, SecondActivity::class.java)

            val regex = Regex("[a-zA-z0-9]")
            val textPassword = password.text.toString()
            val matched = regex.containsMatchIn(textPassword)

            when {
                ((username.length() >= 3) and (password.length() >= 8) and (matched)) -> {
                    textError.visibility = View.INVISIBLE
                    intent.putExtra(SecondActivity.TRANSMITTED, username.text.toString())
                    startActivity(intent)
                }
                ((username.length() < 3) and (password.length() < 8)) -> {
                    textError.visibility = View.VISIBLE
                    textError.text = getString(R.string.login_password_error)
                }
                else -> {
                    when {
                        (username.length() < 3) -> {
                            textError.visibility = View.VISIBLE
                            textError.text = getString(R.string.login_error)
                        }
                        ((password.length() < 3) or (matched == false)) -> {
                            textError.visibility = View.VISIBLE
                            textError.text = getString(R.string.password_error)
                        }
                    }
                }
            }
        }
    }
}
