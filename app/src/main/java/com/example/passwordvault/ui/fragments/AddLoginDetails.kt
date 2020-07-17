package com.example.passwordvault.ui.fragments

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.findNavController
import com.example.passwordvault.databinding.AddLoginBinding
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.ui.dialog.PasswordGeneratorDialog
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Abhinav Singh on 01,July,2020
 */
@AndroidEntryPoint
class AddLoginDetails : Fragment(),AdapterView.OnItemSelectedListener,PasswordGeneratorDialog.OnCopyListener{
    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: AddLoginBinding
    private val categoryList: ArrayList<String> = ArrayList()
    private var category : String = ""


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

        initSpinner()

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
                val id = loginName + loginEmail.split("@")[0]
                viewModel.insertLoginDetails(LoginDetailsItem(id,loginName,loginEmail,loginPassword,loginWebsite,loginNotes,category))
                Toast.makeText(context,"Details Inserted",Toast.LENGTH_SHORT).show()
                val action = AddLoginDetailsDirections.actionAddLoginDetailsToLoginDetails()
                findNavController().navigate(action)
            }
            else
                Toast.makeText(context,"Please fill all blanks",Toast.LENGTH_SHORT).show()
        }

        binding.generatePassword.setOnClickListener {
            val dialog = PasswordGeneratorDialog()
            dialog.show(childFragmentManager,"Dialog")
        }
    }

    private fun initSpinner() {
        categoryList.add("Category")
        categoryList.add("Social")
        categoryList.add("Work")
        categoryList.add("E-Commerce")
        categoryList.add("Others")

        val adapter  = ArrayAdapter<String> (requireContext(),R.layout.simple_spinner_dropdown_item
            ,categoryList)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.loginCategorySpinner.adapter = adapter
        binding.loginCategorySpinner.onItemSelectedListener = this
    }


    private fun valid(loginName : String, loginEmail : String,  loginPassword: String) : Boolean{

        return !(loginName.isEmpty() || loginEmail.isEmpty() || loginPassword.isEmpty() || category.isEmpty())
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
        if(p2 != 0)
            category = categoryList[p2]
    }

    override fun sendPassword(password: String) {
        binding.loginPasswordEt.setText(password)
    }


}