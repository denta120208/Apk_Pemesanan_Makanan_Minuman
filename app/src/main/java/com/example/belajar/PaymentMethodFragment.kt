package com.example.belajar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.RadioGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class PaymentMethodFragment : Fragment() {

    private var selectedPaymentMethod: String? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_payment_method, container, false)

        // Handle RadioGroup for payment methods
        val rgPaymentMethods = view.findViewById<RadioGroup>(R.id.rgPaymentMethods)

        rgPaymentMethods.setOnCheckedChangeListener { _, checkedId ->
            selectedPaymentMethod = when (checkedId) {
                R.id.rbQris -> "Qris"
                R.id.rbCash -> "Cash"
                R.id.rbGopay -> "Gopay"
                else -> null
            }
        }

        // Handle Proceed button click
        val btnProceed = view.findViewById<Button>(R.id.btnProceed)
        btnProceed.setOnClickListener {
            if (selectedPaymentMethod == null) {
                Toast.makeText(context, "Please select a payment method.", Toast.LENGTH_SHORT).show()
            } else {
                navigateToFragment(selectedPaymentMethod!!)
            }
        }

        return view
    }

    private fun navigateToFragment(paymentMethod: String) {
        val targetFragment = when (paymentMethod) {
            "Qris" -> QrisPaymentFragment() // Fragment pembayaran QRIS
            else -> ConfirmationFragment() // Fragment konfirmasi untuk metode lainnya
        }

        // Kirim data ke fragment tujuan
        val bundle = Bundle()
        bundle.putString("payment_method", paymentMethod)
        targetFragment.arguments = bundle

        // Ganti fragment saat ini dengan fragment tujuan
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, targetFragment)
            .addToBackStack(null)
            .commit()
    }
}
