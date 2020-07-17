package com.example.passwordvault.adapter

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RelativeLayout
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordvault.R
import com.example.passwordvault.databinding.DebitCardItemBinding
import com.example.passwordvault.databinding.LoginListItemBinding
import com.example.passwordvault.model.CardDetailsItem
import com.example.passwordvault.model.LoginDetailsItem
import com.wajahatkarim3.easyflipview.EasyFlipView

/**
 * Created by Abhinav Singh on 07,July,2020
 */
class CardDetailsAdapter(private var mContext : Context?, private var mList : List<CardDetailsItem>) : RecyclerView.Adapter<CardDetailsAdapter.CardDetailsViewHolder>() {
    private  lateinit var binding : DebitCardItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardDetailsViewHolder {
        binding = DebitCardItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: CardDetailsViewHolder, position: Int) {
        binding.cardHolder.text = mList[position].cardHolder
        setItemIcon(binding.cardIssuer,mList[position].cardIssuer,binding.debitCardItemCardFront,binding.debitCardItemCardBack,binding.backRelativeLayout,binding.frontRelativeLayout)
        binding.cardExpiry.text = mList[position].cardExpiryMonth +"/" + mList[position].cardExpiryYear
        val splitNumber = mList[position].cardNumber.toString().split("-")
        binding.cardNumberPart1.text = splitNumber[0]
        binding.cardNumberPart2.text = splitNumber[1]
        binding.cardNumberPart3.text = splitNumber[2]
        binding.cardNumberPart4.text = splitNumber[3]
        binding.debitCardCVV.text    = mList[position].cardCvv

        binding.flipView.setOnClickListener {
            it as EasyFlipView
            it.flipTheView()
        }

        binding.flipView.setOnLongClickListener {
            it as EasyFlipView

            var clipboardManager : ClipboardManager = mContext?.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            if(clipboardManager.hasPrimaryClip()){
                var number = mList[position].cardNumber
                number = number.replace(Regex("""[-]"""), "")
                var data : ClipData = ClipData.newPlainText("copied text",number)
                clipboardManager.setPrimaryClip(data)
            }
            Toast.makeText(mContext,"Copied to clipboard", Toast.LENGTH_SHORT).show()
            return@setOnLongClickListener true
        }

    }

    private fun setItemIcon(itemIcon: ImageView,name : String,front : CardView, back : CardView, backLayout : RelativeLayout, frontLayout: RelativeLayout) {
        when(name.toLowerCase().trim()){
            "master card" -> {itemIcon.setImageResource(R.drawable.ic_mc_symbol)
            }
            "visa" -> {itemIcon.setImageResource(R.drawable.ic_visa)
                    front.setCardBackgroundColor(Color.parseColor("#5494F1"))
                    back.setCardBackgroundColor(Color.parseColor("#5494F1"))
                    frontLayout.setBackgroundColor(Color.parseColor("#5494F1"))
                    backLayout.setBackgroundColor(Color.parseColor("#5494F1"))
            }
            "rupay" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "maestro" -> {
                itemIcon.setImageResource(R.drawable.ic_mastercard)
                front.setCardBackgroundColor(Color.parseColor("#ED6033"))
                back.setCardBackgroundColor(Color.parseColor("#ED6033"))
                frontLayout.setBackgroundColor(Color.parseColor("#ED6033"))
                backLayout.setBackgroundColor(Color.parseColor("#ED6033"))
            }

        }
    }

    class CardDetailsViewHolder(binding: DebitCardItemBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    fun getItemAt(position : Int) : CardDetailsItem {
        return mList[position]
    }
}