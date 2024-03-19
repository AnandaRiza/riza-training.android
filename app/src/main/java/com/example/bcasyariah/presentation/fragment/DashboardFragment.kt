package com.example.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentDashboardBinding
import com.example.bcasyariah.databinding.FragmentHistoryBinding

class DashboardFragment : BaseFragment<FragmentDashboardBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentDashboardBinding {
        return FragmentDashboardBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
    }
}