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

            if ((username.length() >= 3) && (password.length() >= 8)) {
                textError.visibility = View.INVISIBLE
                intent.putExtra("transmitted", username.text.toString())
                startActivity(intent)
            } else if (username.length() < 3) {
                textError.visibility = View.VISIBLE
                textError.setText("Че то не так с логином")
            } else if (password.length() < 8) {
                textError.visibility = View.VISIBLE
                textError.setText("Че то не так с паролем")
            }
        }
    }
}