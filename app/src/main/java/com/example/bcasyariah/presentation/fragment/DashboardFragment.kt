package com.example.bcasyariah.presentation.fragment

import HorizontalItemDecoration
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.bcasyariah.R
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.databinding.FragmentHistoryBinding
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.MenuDashboard
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.model.PromoModel
import com.example.bcasyariah.presentation.fragment.adapter.AccountNumberAdapter
import com.example.bcasyariah.presentation.fragment.adapter.DashboardMenuAdapter
import com.example.bcasyariah.presentation.fragment.adapter.PromoAdapter
import com.example.bcasyariah.presentation.viewmodel.DashboardViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {

    private val viewModel : DashboardViewModel by viewModels()

    private lateinit var menuAdapter: DashboardMenuAdapter

    private lateinit var accountAdapter: AccountNumberAdapter

    private lateinit var promoAdapter: PromoAdapter

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
        setupViewPromo()

        viewModel.getHomeMenu()
        viewModel.getAccNum()
        observeViewModel()

    }

    private fun observeViewModel(){
        viewModel.homeMenu.observe(viewLifecycleOwner){
            setupViewMenu(it.data)
        }

        viewModel.accNum.observe(viewLifecycleOwner){
            setupViewAccountNumber(it)
        }
    }

    private fun setupViewMenu(data: List<MenuDashboard>?){

        menuAdapter = DashboardMenuAdapter(
            menuData = data ?: listOf(),
            context = binding.root.context

        )
        binding.componentMenu.gridMenu.adapter = menuAdapter
        binding.componentMenu.gridMenu.onItemClickListener = AdapterView.OnItemClickListener{
                _, _, position, _ ->
            Toast.makeText(
                binding.root.context,
                data?.get(position)?.namaMenu,
                Toast.LENGTH_SHORT).show(
            )
        }
    }

    private fun setupViewPromo(){
        promoAdapter = PromoAdapter(
            data = populateDataPromo(),

        )
        binding.componentPromo.rvPromo.adapter = promoAdapter
        binding.componentPromo.rvPromo.layoutManager = LinearLayoutManager(
            binding.root.context, LinearLayoutManager.HORIZONTAL,false
        )
        binding.componentAccountNumber.rvAccountNumber.apply {
            if (itemDecorationCount <= 0){
                addItemDecoration(horizontalItemDecoration)
            }
        }
    }

    private fun setupViewAccountNumber(data: List<AccountNumberModel>){
        accountAdapter = AccountNumberAdapter(
            data = data,

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



private fun populateDataPromo() : List<PromoModel> {
    return listOf(
        PromoModel(
            image = R.drawable.bca1
        ),

        PromoModel(
            image = R.drawable.bca2
        ),

        PromoModel(
            image = R.drawable.bca3
        ),
        PromoModel(
            image = R.drawable.bca4
        ),
        PromoModel(
            image = R.drawable.bca5
        ),



    )
}




