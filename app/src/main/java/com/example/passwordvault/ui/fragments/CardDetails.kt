package com.example.passwordvault.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.passwordvault.adapter.CardDetailsAdapter
import com.example.passwordvault.adapter.LoginDetailsAdapter
import com.example.passwordvault.databinding.CardsDetailsBinding
import com.example.passwordvault.viewmodel.DetailsViewModel

/**
 * Created by Abhinav Singh on 29,June,2020
 */
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
        observeValue()
    }

    private fun observeValue() {
        viewModel.getAllCardDetails().observe(viewLifecycleOwner, Observer {
            adapter = CardDetailsAdapter(context,it)
            adapter.notifyDataSetChanged()
        })
    }

    private fun initRecyclerView() {
        binding.cardDetailsRecyclerView.layoutManager = LinearLayoutManager(context)
        binding.cardDetailsRecyclerView.adapter = adapter
    }
}