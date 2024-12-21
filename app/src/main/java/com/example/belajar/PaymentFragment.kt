package com.example.belajar

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.fragment.app.Fragment

class PaymentFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_payment, container, false)

        // Initialize the Spinner (dropdown)
        val spinnerClass = view.findViewById<Spinner>(R.id.spinnerClass)

        // Define class options
        val classOptions = arrayOf("IX PPLG 1", "IX PPLG 2", "IX DKV 1","IX HOSPY 2","X AKT","X HOSPY 1")

        // Set up adapter for the Spinner
        val adapter = ArrayAdapter(
            requireContext(),
            android.R.layout.simple_spinner_item,
            classOptions
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinnerClass.adapter = adapter

        // Handle Spinner item selection
        spinnerClass.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                // Optional: Do something with the selected item
                val selectedClass = classOptions[position]
                Toast.makeText(requireContext(), "Selected: $selectedClass", Toast.LENGTH_SHORT).show()
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle case where no item is selected
            }
        }

        // Handle the Proceed Payment button click
        val btnProceedPayment = view.findViewById<Button>(R.id.btnProceedPayment)
        btnProceedPayment.setOnClickListener {
            // Display a toast message
            Toast.makeText(context, "Proceeding to Payment Method", Toast.LENGTH_SHORT).show()

            // Navigate to the PaymentMethodFragment
            val paymentMethodFragment = PaymentMethodFragment() // Instance of the payment method fragment
            parentFragmentManager.beginTransaction()
                .replace(R.id.fragmentContainer, paymentMethodFragment) // Replace current fragment
                .addToBackStack(null) // Add to back stack so we can navigate back
                .commit()
        }

        // Handle the Back button click
        val btnBack = view.findViewById<Button>(R.id.btnBack)
        btnBack.setOnClickListener {
            // Navigate back to the MainActivity and hide the current fragment
            activity?.supportFragmentManager?.beginTransaction()?.apply {
                remove(this@PaymentFragment) // Remove the current fragment
                commit()

                // Optionally, show the main layout and hide the fragment container
                activity?.findViewById<View>(R.id.main)?.visibility = View.VISIBLE
                activity?.findViewById<View>(R.id.fragmentContainer)?.visibility = View.GONE
            }
        }

        // Return the inflated view
        return view
    }
}
