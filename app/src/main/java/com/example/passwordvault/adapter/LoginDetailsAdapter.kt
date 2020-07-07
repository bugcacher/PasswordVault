package com.example.passwordvault.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordvault.R
import com.example.passwordvault.databinding.LoginListItemBinding
import com.example.passwordvault.model.LoginDetailsItem

/**
 * Created by Abhinav Singh on 07,July,2020
 */
class LoginDetailsAdapter(private var mContext : Context?, private var mList : List<LoginDetailsItem>) : RecyclerView.Adapter<LoginDetailsAdapter.LoginDetailsViewHolder>() {
    private  lateinit var binding : LoginListItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginDetailsViewHolder {
        binding = LoginListItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return LoginDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: LoginDetailsViewHolder, position: Int) {
        binding.itemTitle.text = mList.get(position).loginName
        binding.itemid.text = mList[position].loginEmail
        setItemIcon(binding.itemIcon,mList[position].loginName)
        binding.loginItemCard.setOnClickListener {

        }
    }

    private fun setItemIcon(itemIcon: ImageView,name : String) {
        when(name.toLowerCase().trim()){
            "google" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "github" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "slack" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "amazon" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "flipkart" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "facebook" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "instagram" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "reddit" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
            "pinterest" -> itemIcon.setImageResource(R.drawable.ic_mastercard)
        }
    }

    class LoginDetailsViewHolder(binding: LoginListItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}