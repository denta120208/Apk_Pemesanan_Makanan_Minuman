package com.example.belajar

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge() // Mengaktifkan tampilan tepi-ke-tepi
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        // Menangani WindowInsets untuk padding agar tampilan tidak terpotong oleh sistem bar
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Menambahkan aksi untuk tombol Order 1
        findViewById<Button>(R.id.btnLogin).setOnClickListener {
            showToastAndOpenFragment("Order Button 1 Clicked")
        }

        // Menambahkan aksi untuk tombol Order 2
        findViewById<Button>(R.id.btnLogin4).setOnClickListener {
            showToastAndOpenFragment("Order Button 2 Clicked")
        }

        // Menambahkan aksi untuk tombol Order 3
        findViewById<Button>(R.id.btnLogin5).setOnClickListener {
            showToastAndOpenFragment("Order Button 3 Clicked")
        }

        // Menambahkan aksi untuk tombol Order 4
        findViewById<Button>(R.id.btnLogin6).setOnClickListener {
            showToastAndOpenFragment("Order Button 4 Clicked")
        }
    }

    // Fungsi untuk menampilkan toast dan membuka fragment
    private fun showToastAndOpenFragment(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        openFragment(PaymentFragment()) // Menampilkan PaymentFragment
    }

    // Fungsi untuk mengganti fragment
    private fun openFragment(fragment: Fragment) {
        // Sembunyikan layout utama
        findViewById<View>(R.id.main).visibility = View.GONE

        // Tampilkan container untuk fragment
        findViewById<View>(R.id.fragmentContainer).visibility = View.VISIBLE

        // Lakukan transaksi fragment
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment) // Ganti isi container dengan fragment baru
            addToBackStack(null) // Tambahkan ke backstack untuk navigasi kembali
            commitAllowingStateLoss()
        }
    }

    // Handle navigasi kembali
    override fun onBackPressed() {
        val fragmentContainer = findViewById<View>(R.id.fragmentContainer)

        if (fragmentContainer.visibility == View.VISIBLE) {
            // Jika fragment aktif, kembali ke layout utama
            fragmentContainer.visibility = View.GONE
            findViewById<View>(R.id.main).visibility = View.VISIBLE
        } else {
            // Jika tidak ada fragment, lanjutkan dengan aksi default
            super.onBackPressed()
        }
    }
}
