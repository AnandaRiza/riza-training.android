package com.example.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.databinding.FragmentHistoryBinding
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter: DashboardMenuAdapter

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
        menuAdapter = DashboardMenuAdapter(
            menuData = populateDataMenu(),
            context = binding.root.context

        )
        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener{
                _, _, position, _ ->
            Toast.makeText(
                binding.root.context,
                populateDataMenu()[position].menuName,
                Toast.LENGTH_SHORT).show(
            )
        }

    }

    private fun populateDataMenu() : List<MenuDashboardModel> {
        return listOf(
            MenuDashboardModel(
                image = R.drawable.baseline_chat_24,
                menuName = "Transfer"
                ),
            MenuDashboardModel(
                image = R.drawable.baseline_chat_24,
                menuName = "Payment"
            ),
            MenuDashboardModel(
                image = R.drawable.baseline_chat_24,
                menuName = "Jadwal Sholat"
            ),
        )
    }
}