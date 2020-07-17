package com.example.passwordvault.ui.fragments

import android.os.Bundle
import android.util.Log
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
import com.example.passwordvault.adapter.LoginDetailsAdapter
import com.example.passwordvault.databinding.LoginDetailsBinding
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.viewmodel.DetailsViewModel
import dagger.hilt.android.AndroidEntryPoint


/**
 * Created by Abhinav Singh on 29,June,2020
 */
@AndroidEntryPoint
class LoginDetails : Fragment() {

    private lateinit var binding: LoginDetailsBinding
    private lateinit var viewModel : DetailsViewModel
    private lateinit var adapter : LoginDetailsAdapter
    private lateinit var socialList : MutableList<LoginDetailsItem>
    private lateinit var workList : MutableList<LoginDetailsItem>
    private lateinit var eCommerceList : MutableList<LoginDetailsItem>
    private lateinit var othersList : MutableList<LoginDetailsItem>

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginDetailsBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(DetailsViewModel::class.java)

        initRecyclerView()
        setUpItemTouchHelper()
        observeValue()
        setUpOnClickListeners()

    }


    private fun setUpOnClickListeners() {
        binding.filterSocialButton.setOnClickListener{
            adapter.updateList(socialList)
        }

        binding.filterWorkButton.setOnClickListener{
            adapter.updateList(workList)
        }

        binding.filterECommerceButton.setOnClickListener{
            adapter.updateList(eCommerceList)
        }

        binding.filterOtherButton.setOnClickListener{
            adapter.updateList(othersList)
        }
    }

    private fun observeValue() {
        viewModel.getAllLoginDetails().observe(viewLifecycleOwner, Observer {

            adapter = LoginDetailsAdapter(context,it.toMutableList(),requireActivity().supportFragmentManager)
            binding.loginDetailsRecyclerView.adapter = adapter
            adapter.notifyDataSetChanged()
        })

        viewModel.getCategoryLoginDetails("Social").observe(viewLifecycleOwner, Observer{
            socialList = it.toMutableList()
        })

        viewModel.getCategoryLoginDetails("Work").observe(viewLifecycleOwner, Observer{
            workList = it.toMutableList()
        })

        viewModel.getCategoryLoginDetails("Others").observe(viewLifecycleOwner, Observer{
            othersList = it.toMutableList()

        })

        viewModel.getCategoryLoginDetails("E-Commerce").observe(viewLifecycleOwner, Observer{
           eCommerceList = it.toMutableList()

        })

    }

    private fun initRecyclerView() {
        binding.loginDetailsRecyclerView.layoutManager = LinearLayoutManager(context)

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
                    val loginItem: LoginDetailsItem = adapter.getItemAt(swipedItemPosition)
                    viewModel.deleteLoginDetails(loginItem.id)
                    adapter.itemDeleted(loginItem)
                    Toast.makeText(context, "Item deleted", Toast.LENGTH_SHORT)
                        .show()
                }
            }
        val itemTouchHelper = ItemTouchHelper(simpleCallback)
        itemTouchHelper.attachToRecyclerView(binding.loginDetailsRecyclerView)
    }
}