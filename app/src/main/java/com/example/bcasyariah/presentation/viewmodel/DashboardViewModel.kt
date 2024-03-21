package com.example.bcasyariah.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.R
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.MenuDashboardModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel : ViewModel() {

    private val _homeMenu = MutableLiveData<List<MenuDashboardModel>>()
    private val _accNum = MutableLiveData<List<AccountNumberModel>>()

    val homeMenu: LiveData<List<MenuDashboardModel>>
        get() = _homeMenu

    val accNum : LiveData<List<AccountNumberModel>>
        get() = _accNum
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

            )


    }



    fun getHomeMenu() = viewModelScope.launch(Dispatchers.IO){
        _homeMenu.postValue((populateDataMenu()))


    }

    fun getAccNum() = viewModelScope.launch(Dispatchers.IO){
        _accNum.postValue((populateDataAccountNumber()))


    }


}