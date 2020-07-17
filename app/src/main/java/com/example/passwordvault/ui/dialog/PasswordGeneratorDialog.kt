package com.example.passwordvault.ui.dialog

import android.app.Dialog
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.SeekBar
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatDialog
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager
import com.example.passwordvault.databinding.ActivityMainBinding.inflate
import com.example.passwordvault.databinding.BankDialogBinding
import com.example.passwordvault.databinding.LoginDialogBinding
import com.example.passwordvault.databinding.PasswordGeneratorBinding
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.LoginDetailsItem

/**
 * Created by Abhinav Singh on 08,July,2020
 */
class PasswordGeneratorDialog() : DialogFragment() {

    private  lateinit var binding : PasswordGeneratorBinding
    private  var length : Int = 0
    private var pass = ""
    private lateinit var listener : OnCopyListener

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        binding = PasswordGeneratorBinding.inflate(LayoutInflater.from(requireContext()))

        val builder = AlertDialog.Builder(requireContext())
        builder.setView(binding.root)

        binding.generatePassword.setOnClickListener {

            pass = ""
            length = binding.lengthSeekBar.progress

            var list  = ArrayList<Int>()
            if(binding.capitalsSwitch.isChecked)
                list.add(0)
            if(binding.smallLetterSwitch.isChecked)
                list.add(1)
            if(binding.numberSwitch.isChecked)
                list.add(2)
            if(binding.symbolSwitch.isChecked)
                list.add(3)

            for(i in 1..length){
                var choice = list.random()
                when(choice){
                    0-> pass += ('A'..'Z').random().toString()
                    1-> pass += ('a'..'z').random().toString()
                    2-> pass += ('0'..'9').random().toString()
                    3-> pass += listOf('!','@','#','$','%','&','*','+','=','-','~').random().toString()
                }
            }
            binding.generatedPassword.text = pass
            binding.generatePassword.text = "Regenerate"
        }
        binding.copyPassword.setOnClickListener {
            listener.sendPassword(pass)
            Toast.makeText(requireContext(),"Password Selected",Toast.LENGTH_SHORT).show()
            dismiss()
        }

        binding.lengthSeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                binding.lengthText.text = "Length: $p1"
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        return builder.create()


    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = parentFragment as OnCopyListener
    }

    interface OnCopyListener{
        fun sendPassword(password:String)
    }

}