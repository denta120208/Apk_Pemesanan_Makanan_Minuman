package com.example.belajar

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var loginButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Menginisialisasi elemen UI
        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        loginButton = findViewById(R.id.loginButton)

        loginButton.setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            // Validasi login berdasarkan username dan password
            if (validateLogin(username, password)) {
                val intent = if (username == "2" && password == "2") {
                    // Jika admin, langsung buka AdminActivity
                    Intent(this, AdminActivity::class.java)
                } else {
                    // Jika bukan admin, buka MainActivity
                    Intent(this, MainActivity::class.java)
                }
                startActivity(intent)
                finish()  // Menghentikan LoginActivity setelah berhasil login
            } else {
                Toast.makeText(this, "Username atau Password salah", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Validasi login berdasarkan username dan password
    private fun validateLogin(username: String, password: String): Boolean {
        // Memeriksa login untuk Admin dan Customer
        return when {
            username == "2" && password == "2" -> true  // Admin
            username == "1" && password == "1" -> true  // Customer
            else -> false
        }
    }
}
