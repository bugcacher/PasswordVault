package com.example.passwordvault.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordvault.databinding.BankListItemBinding
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.ui.dialog.BankDialog

/**
 * Created by Abhinav Singh on 07,July,2020
 */
class BankDetailsAdapter(private var mContext : Context?, private var mList : List<BankDetailsItem>, private var fragmentManager : FragmentManager) : RecyclerView.Adapter<BankDetailsAdapter.BankDetailsViewHolder>() {
    private  lateinit var binding : BankListItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BankDetailsViewHolder {
        binding = BankListItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return BankDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: BankDetailsViewHolder, position: Int) {
        binding.bankName.text = mList.get(position).bankName
        binding.bankAccountNumber.text = mList[position].bankAccNumber.toString()
        binding.bankItemCard.setOnClickListener {
            val dialog = BankDialog(mList[position])
            dialog.show(fragmentManager,"Bank Dialog")
        }
    }

    class BankDetailsViewHolder(binding: BankListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
    fun getItemAt(position : Int) : BankDetailsItem {
        return mList[position]
    }
}