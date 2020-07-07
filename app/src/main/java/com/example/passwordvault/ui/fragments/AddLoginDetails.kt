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
import androidx.annotation.AnimRes
import androidx.annotation.Nullable
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.passwordvault.databinding.AddBankBinding
import com.example.passwordvault.databinding.AddCardBinding
import com.example.passwordvault.databinding.AddLoginBinding
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.add_login.*
import android.widget.AdapterView.OnItemSelectedListener as OnItemSelectedListener1


/**
 * Created by Abhinav Singh on 01,July,2020
 */
@AndroidEntryPoint
class AddLoginDetails : Fragment(){
    private lateinit var viewModel: DetailsViewModel
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
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        binding.addLoginDetails.setOnClickListener {
            var loginName       = binding.loginNameEt.text.toString().trim()
            var loginEmail      = binding.loginEmailEt.text.toString().trim()
            var loginPassword   = binding.loginPasswordEt.text.toString().trim()
            var loginWebsite    = binding.loginWebsiteEt.text.toString().trim()
            var loginNotes      = binding.loginNoteEt.text.toString().trim()

            if(loginWebsite.isEmpty())
                loginWebsite = " "
            if(loginNotes.isEmpty())
                loginNotes  = " "

            if(valid(loginName,loginEmail,loginPassword)){
                viewModel.insertLoginDetails(LoginDetailsItem(loginName,loginEmail,loginPassword,loginWebsite,loginNotes))
                Toast.makeText(context,"Details Inserted",Toast.LENGTH_SHORT).show()
            }
            else
                Toast.makeText(context,"Please fill all blanks",Toast.LENGTH_SHORT).show()
        }
    }



    private fun valid(loginName : String, loginEmail : String,  loginPassword: String) : Boolean{

        return !(loginName.isEmpty() || loginEmail.isEmpty() || loginPassword.isEmpty())
    }
}