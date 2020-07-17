package com.example.passwordvault.ui.fragments

import android.R
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.passwordvault.databinding.AddCardBinding
import com.example.passwordvault.model.CardDetailsItem
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Abhinav Singh on 01,July,2020
 */
@AndroidEntryPoint
class AddCardDetails : Fragment(), AdapterView.OnItemSelectedListener{
    private lateinit var viewModel: DetailsViewModel
    private lateinit var binding: AddCardBinding
    private var cardIssuer : String = "Master Card"
    private var issuerList: ArrayList<String> = ArrayList()
    private var count : Int = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = AddCardBinding.inflate(inflater,container,false)
        return binding.root    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        setUpTextWatcher()
        initSpinner()
        binding.addDebitCard.setOnClickListener {
            var cardNumber = binding.cardNumberEt.text.toString().trim()
            var cardHolder = binding.cardHolderEt.text.toString().trim()
            var cardCVV    = binding.cardCvvEt.text.toString().trim()
            var cardExpiry = binding.cardExpiryEt.text.toString().trim()

            if(valid(cardNumber,cardHolder,cardExpiry,cardCVV)){
                var split : Array<String> = cardExpiry.split("/").toTypedArray()

                viewModel.insertCardDetails(CardDetailsItem(cardHolder,cardIssuer,cardNumber,
                    split[0],split[1],cardCVV))
                Toast.makeText(context,"Details Inserted",Toast.LENGTH_SHORT).show()
                val action = AddCardDetailsDirections.actionAddCardDetailsToCardDetails()
                findNavController().navigate(action)
            }
            else
                Toast.makeText(context,"Please fil all blanks",Toast.LENGTH_SHORT).show()
        }
    }

    private fun setUpTextWatcher() {

        binding.cardNumberEt.addTextChangedListener(object : TextWatcher{
            private val TOTAL_SYMBOLS = 19 // size of pattern 0000-0000-0000-0000
            private val TOTAL_DIGITS = 16 // max numbers of digits in pattern: 0000 x 4
            private val DIVIDER_MODULO =
                5 // means divider position is every 5th symbol beginning with 1
            private val DIVIDER_POSITION =
                DIVIDER_MODULO - 1 // means divider position is every 4th symbol beginning with 0
            private val DIVIDER = '-'

            override fun afterTextChanged(text: Editable) {

                if (!isInputCorrect(text, TOTAL_SYMBOLS, DIVIDER_MODULO, DIVIDER)) {

                    var repl = buildCorrectString(
                        getDigitArray(text, TOTAL_DIGITS),
                        DIVIDER_POSITION,
                        DIVIDER
                    )

                    binding.cardNumberEt.clearFocus();
                    binding.cardNumberEt.setText(repl);
                    binding.cardNumberEt.requestFocus();
                    binding.cardNumberEt.setSelection(repl!!.length);

                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int) {

            }
            private fun isInputCorrect(
                s: Editable,
                totalSymbols: Int,
                dividerModulo: Int,
                divider: Char
            ): Boolean {
                var isCorrect =
                    s.length <= totalSymbols // check size of entered string
                for (i in s.indices) { // check that every element is right
                    isCorrect = if (i > 0 && (i + 1) % dividerModulo == 0) {
                        isCorrect and (divider == s[i])
                    } else {
                        isCorrect and Character.isDigit(s[i])
                    }
                }
                return isCorrect
            }

            private fun buildCorrectString(
                digits: CharArray,
                dividerPosition: Int,
                divider: Char
            ): String? {
                val formatted = StringBuilder()
                for (i in digits.indices) {
                    if (digits[i] != '\u0000') {
                        formatted.append(digits[i])
                        if (i > 0 && i < digits.size - 1 && (i + 1) % dividerPosition == 0) {
                            formatted.append(divider)
                        }
                    }
                }
                return formatted.toString()
            }

            private fun getDigitArray(s: Editable, size: Int): CharArray {
                val digits = CharArray(size)
                var index = 0
                var i = 0
                while (i < s.length && index < size) {
                    val current = s[i]
                    if (Character.isDigit(current)) {
                        digits[index] = current
                        index++
                    }
                    i++
                }
                return digits
            }

        })

        binding.cardExpiryEt.addTextChangedListener(object : TextWatcher{
            var first = 0

            override fun afterTextChanged(text: Editable) {
                var second = first;
                first = text.length

                if(binding.cardExpiryEt.text.length==2 && first>second){
                    binding.cardExpiryEt.append("/");
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(sequence: CharSequence?, start: Int, before: Int, count: Int) {

            }

        })


    }

    private fun initSpinner() {
        issuerList.add("Issuer")
        issuerList.add("Master Card")
        issuerList.add("Maestro")
        issuerList.add("Rupay")
        issuerList.add("Visa")

        val adapter  = ArrayAdapter<String> (requireContext(),R.layout.simple_spinner_dropdown_item
                                            ,issuerList)
        adapter.setDropDownViewResource(R.layout.simple_spinner_dropdown_item)
        binding.issuerSpinner.adapter = adapter
        binding.issuerSpinner.onItemSelectedListener = this
    }

    private fun valid(cardNumber : String, cardHolder : String,  cardExpiry: String, cardCVV: String) : Boolean{
        val list = cardExpiry.split("/")

        return !(cardNumber.isEmpty() || cardHolder.isEmpty() || cardCVV.isEmpty()
                || cardExpiry.isEmpty() || cardIssuer.isEmpty() || list[0].toInt() > 12)
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        if(position != 0)
            cardIssuer = issuerList[position]
    }
}