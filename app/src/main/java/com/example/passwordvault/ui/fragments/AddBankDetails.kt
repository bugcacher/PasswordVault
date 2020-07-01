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
import com.example.passwordvault.databinding.AddBankBinding
import com.example.passwordvault.databinding.AddCardBinding
import android.widget.AdapterView.OnItemSelectedListener as OnItemSelectedListener1


/**
 * Created by Abhinav Singh on 01,July,2020
 */
class AddBankDetails : Fragment(){
    private lateinit var binding: AddBankBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddBankBinding.inflate(inflater,container,false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addBankDetails.setOnClickListener {
            if(valid()){
                // todo save card
            }
            else
                Toast.makeText(context,"Please fill all blanks",Toast.LENGTH_SHORT).show()
        }
    }



    private fun valid() : Boolean{
        var bankAccNumber = binding.bankAccountNumberEt.text.toString().trim()
        var bankName      = binding.bankNameEt.text.toString().trim()
        var bankAddress   = binding.bankAddressEt.text.toString().trim()
        var bankIFSC      = binding.bankIFSCEt.text.toString().trim()
        return !(bankAccNumber.isEmpty() || bankAddress.isEmpty() || bankName.isEmpty()
                || bankIFSC.isEmpty())
    }
}