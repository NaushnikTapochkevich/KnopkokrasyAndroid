package com.naushnik.knopkokrasyandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //инициализируем вьюшки
        val username: EditText = findViewById(R.id.edit_user)
        val password: EditText = findViewById(R.id.edit_password)
        val btnAuthorization: Button = findViewById(R.id.button_login)


        val intent = Intent(this@MainActivity, SecondActivity::class.java)


        btnAuthorization.setOnClickListener {
            if ((username.length() >= 3) && (password.length() >= 8)) {
                startActivity(intent)
            } else {
                Toast.makeText(applicationContext, "error", Toast.LENGTH_LONG).show()
            }
        }
        val transmitted = username.text
        intent.putExtra("transmitted", transmitted)
    }
}