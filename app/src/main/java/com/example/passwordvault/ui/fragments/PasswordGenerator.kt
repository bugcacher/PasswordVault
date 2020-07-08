package com.example.passwordvault.ui.fragments

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.passwordvault.databinding.PasswordGeneratorBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.security.auth.login.LoginException

/**
 * Created by Abhinav Singh on 29,June,2020
 */
class PasswordGenerator : Fragment() {

    private lateinit var binding: PasswordGeneratorBinding
    private  var length : Int = 0
    private var pass = ""

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
            var clipboardManager : ClipboardManager = requireActivity().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var data : ClipData = ClipData.newPlainText("copied text",pass)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(requireContext(),"Copied to clipboard", Toast.LENGTH_SHORT).show()
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



    }

}