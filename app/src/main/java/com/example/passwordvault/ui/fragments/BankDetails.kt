package com.example.passwordvault.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.passwordvault.databinding.BankDetailsBinding
import com.example.passwordvault.db.BankDao
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Abhinav Singh on 29,June,2020
 */
@AndroidEntryPoint
class BankDetails : Fragment() {
    private lateinit var binding: BankDetailsBinding
    private lateinit var viewModel: DetailsViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BankDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)
        viewModel.getAllBankDetails().observe(viewLifecycleOwner, Observer<List<BankDetailsItem>> {
            Log.e("__________","size: " + it[0].bankAccNumber)
        })

    }
}