package com.example.bcasyariah.presentation.fragment

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.bcasyariah.base.BaseFragment
import com.example.bcasyariah.databinding.FragmentNotificationBinding

class NotificationFragment: BaseFragment<FragmentNotificationBinding>() {
    override fun inflateBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentNotificationBinding {
        return FragmentNotificationBinding.inflate(inflater, container, false)
    }

    override fun setupView() {
    }
}