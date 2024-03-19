package com.example.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentHistoryBinding

class HistoryFragment : BaseFragment<FragmentHistoryBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        Container: ViewGroup?
    ): FragmentHistoryBinding {
        return FragmentHistoryBinding.inflate(inflater, Container, false)
    }

    override fun setupView() {
    }

}