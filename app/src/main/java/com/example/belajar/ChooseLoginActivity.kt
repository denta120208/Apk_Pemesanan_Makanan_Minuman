package com.example.belajar

import android.content.Intent  // Import the Intent class
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class ChooseLoginActivity : AppCompatActivity() {

    private lateinit var adminButton: Button
    private lateinit var customerButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_login)

        // Inisialisasi tombol
        adminButton = findViewById(R.id.adminButton)
        customerButton = findViewById(R.id.customerButton)

        // Aksi tombol Admin
        adminButton.setOnClickListener {
            // Arahkan langsung ke LoginActivity dengan userType "Admin"
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userType", "Admin") // Mengirim data userType untuk Admin
            startActivity(intent)
        }

        // Aksi tombol Customer
        customerButton.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("userType", "Customer") // Mengirim data userType untuk Customer
            startActivity(intent)
        }
    }
}
