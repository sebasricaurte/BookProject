package com.ricaurte.bookproject

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.ricaurte.bookproject.databinding.ActivityRegisterBinding

class RegisterActivity : AppCompatActivity() {
    private lateinit var registerBinding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        registerBinding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(registerBinding.root)

        with(registerBinding) {
            registerButton.setOnClickListener {
                val email = emailEditText.text.toString()
                val password = passwordEditText.text.toString()
                val repPassword = repPasswordEditText.text.toString()

                if (password == repPassword){
                    val intent = Intent(this@RegisterActivity, LoginActivity::class.java)
                    intent.putExtra("email",email)
                    intent.putExtra("password", password)
                    startActivity(intent)
                } else
                    Toast.makeText(applicationContext,"Las contraseñas deben iguales", Toast.LENGTH_SHORT).show()

            }
        }
    }
}