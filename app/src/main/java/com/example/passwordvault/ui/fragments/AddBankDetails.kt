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
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import com.example.passwordvault.databinding.AddBankBinding
import com.example.passwordvault.databinding.AddCardBinding
import com.example.passwordvault.db.BankDao
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject
import android.widget.AdapterView.OnItemSelectedListener as OnItemSelectedListener1


/**
 * Created by Abhinav Singh on 01,July,2020
 */
@AndroidEntryPoint
class AddBankDetails : Fragment(){
    private lateinit var viewModel: DetailsViewModel
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

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        binding.addBankDetails.setOnClickListener {
            var bankAccNumber = binding.bankAccountNumberEt.text.toString().trim()
            var bankName      = binding.bankNameEt.text.toString().trim()
            var bankAddress   = binding.bankAddressEt.text.toString().trim()
            var bankIFSC      = binding.bankIFSCEt.text.toString().trim()

            if(valid(bankName,bankAccNumber,bankIFSC,bankAddress)){
                viewModel.insertBankDetails(BankDetailsItem(bankName,bankAccNumber.toLong(),bankIFSC,bankAddress))
                Toast.makeText(context,"Details Inserted",Toast.LENGTH_SHORT).show()
                val action = AddBankDetailsDirections.actionAddBankDetailsToBankDetails()
                findNavController().navigate(action)
            }
            else
                Toast.makeText(context,"Please fill all blanks",Toast.LENGTH_SHORT).show()
        }
    }



    private fun valid(bankName : String, bankAccNumber : String,  bankIFSC: String, bankAddress: String) : Boolean{
        return !(bankAccNumber.isEmpty() || bankAddress.isEmpty() || bankName.isEmpty()
                || bankIFSC.isEmpty())
    }
}