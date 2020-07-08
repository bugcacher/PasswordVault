package com.example.passwordvault.ui.dialog

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.DialogFragment
import com.example.passwordvault.databinding.LoginDialogBinding
import com.example.passwordvault.model.LoginDetailsItem

/**
 * Created by Abhinav Singh on 08,July,2020
 */
class LoginDialog(private val loginItem : LoginDetailsItem) : DialogFragment() {

    private  lateinit var binding : LoginDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = LoginDialogBinding.inflate(LayoutInflater.from(context))

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(binding.root)

        binding.loginCategory.text = loginItem.loginCategory
        binding.loginEmailEt.text = loginItem.loginEmail
        binding.loginNameEt.text = loginItem.loginName
        binding.loginPasswordEt.text = loginItem.loginPassword
        binding.loginWebsiteEt.text = loginItem.loginWebsite
        binding.loginNoteEt.text = loginItem.loginNotes

        setUpOnClick()

        return builder.create()


    }

    private fun setUpOnClick() {
        binding.copyEmail.setOnClickListener {
            var clipboardManager : ClipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var data : ClipData = ClipData.newPlainText("copied text",loginItem.loginEmail)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(requireContext(),"Copied to clipboard", Toast.LENGTH_SHORT).show()
        }

        binding.copyPassword.setOnClickListener {
            var clipboardManager : ClipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var data : ClipData = ClipData.newPlainText("copied text",loginItem.loginPassword)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(requireContext(),"Copied to clipboard",Toast.LENGTH_SHORT).show()
        }

        binding.goToWebsite.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(loginItem.loginWebsite))
            requireActivity().startActivity(intent)
        }

    }

}