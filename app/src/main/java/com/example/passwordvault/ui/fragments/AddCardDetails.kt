package com.example.passwordvault.ui.fragments

import android.R
import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import com.example.passwordvault.databinding.AddCardBinding
import android.widget.AdapterView.OnItemSelectedListener as OnItemSelectedListener1


/**
 * Created by Abhinav Singh on 01,July,2020
 */
class AddCardDetails : Fragment(), AdapterView.OnItemSelectedListener{
    private lateinit var binding: AddCardBinding
    private var cardIssuer : String = "Master Card"
    val issuerList: ArrayList<String> = ArrayList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddCardBinding.inflate(inflater,container,false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initSpinner()
        binding.addDebitCard.setOnClickListener {
            if(valid()){
                // todo save card
            }
            else
                Toast.makeText(context,"Please fil all blanks",Toast.LENGTH_SHORT).show()
        }
    }

    private fun initSpinner() {
        issuerList.add("Master Card")
        issuerList.add("Maestro")
        issuerList.add("Rupay")
        issuerList.add("Visa")

        val adapter  = ArrayAdapter<String> (requireContext(),R.layout.simple_spinner_dropdown_item
                                            ,issuerList)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.issuerSpinner.adapter = adapter
        binding.issuerSpinner.onItemSelectedListener = this
    }

    private fun valid() : Boolean{
        var cardNumber = binding.cardNumberEt.text.toString().trim()
        var cardHolder = binding.cardHolderEt.text.toString().trim()
        var cardCVV    = binding.cardCvvEt.text.toString().trim()
        var cardExpiry = binding.cardExpiryEt.text.toString().trim()
        return !(cardNumber.isEmpty() || cardHolder.isEmpty() || cardCVV.isEmpty()
                || cardExpiry.isEmpty())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        cardIssuer = issuerList[position]
    }
}