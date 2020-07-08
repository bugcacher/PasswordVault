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
import com.example.passwordvault.databinding.BankDialogBinding
import com.example.passwordvault.databinding.LoginDialogBinding
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.LoginDetailsItem

/**
 * Created by Abhinav Singh on 08,July,2020
 */
class BankDialog(private val bankItem : BankDetailsItem) : DialogFragment() {

    private  lateinit var binding : BankDialogBinding
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = BankDialogBinding.inflate(LayoutInflater.from(requireContext()))

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(binding.root)
        binding.bankAccountNumberEt.text = bankItem.bankAccNumber.toString()
        binding.bankNameEt.text = bankItem.bankName
        binding.bankAddressEt.text = bankItem.bankAddress
        binding.bankIFSCEt.text = bankItem.bankIFSC


        setUpOnClick()

        return builder.create()


    }

    private fun setUpOnClick() {
        binding.copyAccountNumber.setOnClickListener {
            var clipboardManager : ClipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var data : ClipData = ClipData.newPlainText("copied text",bankItem.bankAccNumber.toString())
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(requireContext(),"Copied to clipboard",Toast.LENGTH_SHORT).show()
        }

        binding.copyAddress.setOnClickListener {
            var clipboardManager : ClipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var data : ClipData = ClipData.newPlainText("copied text",bankItem.bankAddress)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(requireContext(),"Copied to clipboard",Toast.LENGTH_SHORT).show()
        }

        binding.copyIFSC.setOnClickListener {
            var clipboardManager : ClipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var data : ClipData = ClipData.newPlainText("copied text",bankItem.bankIFSC)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(requireContext(),"Copied to clipboard",Toast.LENGTH_SHORT).show()
        }


        binding.copyBankName.setOnClickListener {
            var clipboardManager : ClipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var data : ClipData = ClipData.newPlainText("copied text",bankItem.bankName)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(requireContext(),"Copied to clipboard",Toast.LENGTH_SHORT).show()
        }

    }

}