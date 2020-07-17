package com.example.passwordvault.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.passwordvault.adapter.CardDetailsAdapter
import com.example.passwordvault.adapter.LoginDetailsAdapter
import com.example.passwordvault.databinding.CardsDetailsBinding
import com.example.passwordvault.model.CardDetailsItem
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint

/**
 * Created by Abhinav Singh on 29,June,2020
 */
@AndroidEntryPoint
class CardDetails : Fragment() {

    private lateinit var binding: CardsDetailsBinding
    private lateinit var viewModel : DetailsViewModel
    private lateinit var adapter : CardDetailsAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = CardsDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        initRecyclerView()
        setUpItemTouchHelper()
        observeValue()
    }

    private fun observeValue() {
        viewModel.getAllCardDetails().observe(viewLifecycleOwner, Observer {
            adapter = CardDetailsAdapter(context,it)
            binding.cardDetailsRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        binding.cardDetailsRecyclerView.layoutManager = LinearLayoutManager(context)

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
                    val cardItem: CardDetailsItem = adapter.getItemAt(swipedItemPosition)
                    viewModel.deleteCardDetails(cardItem.cardNumber)
                    adapter.notifyDataSetChanged()
                    Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.cardDetailsRecyclerView)
    }
}