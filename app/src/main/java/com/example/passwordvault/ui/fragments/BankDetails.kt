package com.example.passwordvault.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordvault.adapter.BankDetailsAdapter
import com.example.passwordvault.adapter.LoginDetailsAdapter
import com.example.passwordvault.databinding.BankDetailsBinding
import com.example.passwordvault.db.BankDao
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

/**
 * Created by Abhinav Singh on 29,June,2020
 */
@AndroidEntryPoint
class BankDetails : Fragment() {
    private lateinit var binding: BankDetailsBinding
    private lateinit var viewModel : DetailsViewModel
    private lateinit var adapter : BankDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = BankDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        initRecyclerView()
        observeValue()

    }

    private fun observeValue() {
        viewModel.getAllBankDetails().observe(viewLifecycleOwner, Observer {
            adapter = BankDetailsAdapter(context,it,requireActivity().supportFragmentManager)
            binding.bankDetailsRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        binding.bankDetailsRecyclerView.layoutManager = LinearLayoutManager(context)

    }

    private fun setUpItemTouchHelper() {
        val simpleCallback: ItemTouchHelper.SimpleCallback =
            object : ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {
                override fun onMove(
                    recyclerView: RecyclerView,
                    viewHolder: RecyclerView.ViewHolder,
                    target: RecyclerView.ViewHolder
                ): Boolean {
                    return false
                }

                override fun onSwiped(
                    viewHolder: RecyclerView.ViewHolder,
                    direction: Int
                ) {
                    val swipedItemPosition = viewHolder.adapterPosition
                    val bankItem: BankDetailsItem = adapter.getItemAt(swipedItemPosition)
                    viewModel.deleteBankDetails(bankItem.bankAccNumber)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.bankDetailsRecyclerView)
    }
}