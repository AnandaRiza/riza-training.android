package com.example.bcasyariah.presentation.fragment

import HorizontalItemDecoration
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.databinding.FragmentHistoryBinding
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.presentation.fragment.adapter.AccountNumberAdapter
import com.example.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private lateinit var menuAdapter: DashboardMenuAdapter

    private lateinit var accountAdapter: AccountNumberAdapter

    private val horizontalItemDecoration by lazy {
        HorizontalItemDecoration(
            resources.getDimensionPixelSize(R.dimen.spacing16),
            true
        )
    }

    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
    setupViewMenu()
        setupViewAccountNumber()

    }

    private fun setupViewMenu(){
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

    private fun setupViewAccountNumber(){
        accountAdapter = AccountNumberAdapter(
            data = populateDataAccountNumber(),

        )
        binding.componentAccountNumber.rvAccountNumber.adapter = accountAdapter
        binding.componentAccountNumber.rvAccountNumber.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL,false
        )
        binding.componentAccountNumber.rvAccountNumber.apply {
            if (itemDecorationCount <= 0){
                addItemDecoration(horizontalItemDecoration)
            }
        }

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

    private fun populateDataAccountNumber() : List<AccountNumberModel>{
        return listOf(
            AccountNumberModel(
                savingType = 2,
                accNumber = 32321310,
                ballanceAmount = "Rp5.000.000"
            ),
            AccountNumberModel(
                savingType = 4,
                accNumber = 32104,
                ballanceAmount = "Rp231.032.412"
            ),
//            AccountNumberModel(
//                savingType = 0,
//                accNumber = 0,
//                ballanceAmount = ""
//            )
        )
    }




