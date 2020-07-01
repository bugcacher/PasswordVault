package com.example.passwordvault.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.passwordvault.databinding.PasswordGeneratorBinding

/**
 * Created by Abhinav Singh on 29,June,2020
 */
class PasswordGenerator : Fragment() {

    private lateinit var binding: PasswordGeneratorBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = PasswordGeneratorBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}