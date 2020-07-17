package com.example.passwordvault.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordvault.R
import com.example.passwordvault.databinding.LoginListItemBinding
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.ui.dialog.LoginDialog

/**
 * Created by Abhinav Singh on 07,July,2020
 */
class LoginDetailsAdapter(private var mContext : Context?, private var mList : MutableList<LoginDetailsItem>,private var fragmentManager : FragmentManager) : RecyclerView.Adapter<LoginDetailsAdapter.LoginDetailsViewHolder>() {
    private  lateinit var binding : LoginListItemBinding



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LoginDetailsViewHolder {
        binding = LoginListItemBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return LoginDetailsViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    override fun onBindViewHolder(holder: LoginDetailsViewHolder, position: Int) {
//        binding.itemTitle.text = mList[position].loginName
//        binding.itemid.text = mList[position].loginEmail
//        setItemIcon(binding.itemIcon,mList[position].loginName)
//        binding.loginItemCard.setOnClickListener {
//            val dialog = LoginDialog(mList[position])
//            dialog.show(fragmentManager,"Login Dialog")
//        }
        holder.bindItem(mList[position],fragmentManager)
    }


    fun updateList(updatedList : MutableList<LoginDetailsItem>){
        val callback = CustomCallback(mList,updatedList)
        val result  = DiffUtil.calculateDiff(callback)

        mList.clear()
        mList.addAll(updatedList)
        result.dispatchUpdatesTo(this)
    }
    fun itemDeleted(loginItem: LoginDetailsItem){
        var newList : ArrayList<LoginDetailsItem> = ArrayList()
        newList.addAll(mList)
        newList.toMutableList()
        mList.remove(loginItem)
        val callback = CustomCallback(newList,mList)
        val result  = DiffUtil.calculateDiff(callback)
        result.dispatchUpdatesTo(this)
    }

    fun getItemAt(position : Int) : LoginDetailsItem{
        return mList[position]
    }

    class LoginDetailsViewHolder(private val binding: LoginListItemBinding) : RecyclerView.ViewHolder(binding.root) {

            fun bindItem(loginItem : LoginDetailsItem, fragmentManager: FragmentManager){
                binding.itemTitle.text = loginItem.loginName
                binding.itemid.text = loginItem.loginEmail
                setItemIcon(binding.itemIcon,loginItem.loginName)
                binding.loginItemCard.setOnClickListener {
                    val dialog = LoginDialog(loginItem)
                    dialog.show(fragmentManager,"Login Dialog")
                }
            }

       private fun setItemIcon(itemIcon: ImageView,name : String) {
            when(name.toLowerCase().trim()){
                "google" -> itemIcon.setImageResource(R.drawable.gmail)
                "github" -> itemIcon.setImageResource(R.drawable.github)
                "slack" -> itemIcon.setImageResource(R.drawable.slack)
                "amazon" -> itemIcon.setImageResource(R.drawable.amazon)
                "flipkart" -> itemIcon.setImageResource(R.drawable.flipkart)
                "facebook" -> itemIcon.setImageResource(R.drawable.facebook)
                "instagram" -> itemIcon.setImageResource(R.drawable.instagram)
                "reddit" -> itemIcon.setImageResource(R.drawable.reddit)
                "pinterest" -> itemIcon.setImageResource(R.drawable.pinterest)
                "linkedin" -> itemIcon.setImageResource(R.drawable.linkedin)
                "spotify" -> itemIcon.setImageResource(R.drawable.spotify)
                "dribble" -> itemIcon.setImageResource(R.drawable.dribble)
                "teamviewer" -> itemIcon.setImageResource(R.drawable.team)
            }
        }
    }

    class CustomCallback(private val oldList: MutableList<LoginDetailsItem>, private val newList: MutableList<LoginDetailsItem>) : DiffUtil.Callback() {
        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
                return oldItemPosition == newItemPosition
        }

        override fun getOldListSize(): Int {
            return oldList.size
        }

        override fun getNewListSize(): Int {
            return newList.size
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldList[oldItemPosition] == newList[newItemPosition]
        }

    }
}