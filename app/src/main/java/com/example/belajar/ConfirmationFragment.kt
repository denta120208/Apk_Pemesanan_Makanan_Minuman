package com.example.belajar

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment

class ConfirmationFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_confirmation, container, false)

        // Retrieve and display payment method
        val paymentMethod = arguments?.getString("payment_method")
        val tvPaymentMethod = view.findViewById<TextView>(R.id.tvPaymentMethod)
        tvPaymentMethod.text = "Payment Method: $paymentMethod"

        // Handle Done button
        val btnDone = view.findViewById<Button>(R.id.btnDone)
        btnDone.setOnClickListener {
            // Navigate back to MainActivity
            val intent = Intent(activity, MainActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            activity?.finish() // Close the current activity to ensure no backstack remains
        }

        return view
    }
}
