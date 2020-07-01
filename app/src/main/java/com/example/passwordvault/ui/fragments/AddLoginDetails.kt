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
import com.example.passwordvault.databinding.AddLoginBinding
import android.widget.AdapterView.OnItemSelectedListener as OnItemSelectedListener1


/**
 * Created by Abhinav Singh on 01,July,2020
 */
class AddLoginDetails : Fragment(){
    private lateinit var binding: AddLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddLoginBinding.inflate(inflater,container,false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.addLoginDetails.setOnClickListener {
            if(valid()){
                // todo save card
            }
            else
                Toast.makeText(context,"Please fill all blanks",Toast.LENGTH_SHORT).show()
        }
    }



    private fun valid() : Boolean{
        var loginName       = binding.loginNameEt.text.toString().trim()
        var loginEmail      = binding.loginEmailEt.text.toString().trim()
        var loginPassword   = binding.loginPasswordEt.text.toString().trim()
        var loginWebsite    = binding.loginWebsiteEt.text.toString().trim()
        var loginNotes      = binding.loginNoteEt.text.toString().trim()
        return !(loginName.isEmpty() || loginEmail.isEmpty() || loginPassword.isEmpty())
    }
}