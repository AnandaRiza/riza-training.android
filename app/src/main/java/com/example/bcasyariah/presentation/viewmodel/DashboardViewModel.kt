package com.example.bcasyariah.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bcasyariah.R
import com.example.bcasyariah.data.remote.MenuDashboardRemoteDatasource
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.MenuDashboard
import com.example.bcasyariah.model.MenuDashboardModel
import com.example.bcasyariah.model.MenuDashboardResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val menuDashboardRemoteDatasource : MenuDashboardRemoteDatasource
) : ViewModel() {


    private val _homeMenu = MutableLiveData<MenuDashboardResponse>()
    private val _accNum = MutableLiveData<List<AccountNumberModel>>()
    private val _homeMenuError = MutableLiveData<String>()

    val homeMenu: LiveData<MenuDashboardResponse>
        get() = _homeMenu

    val homeMenuError : LiveData<String>
        get() = _homeMenuError
    val accNum : LiveData<List<AccountNumberModel>>
        get() = _accNum

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
        menuDashboardRemoteDatasource.getMenuDashboard().let {
            if (it.isSuccessful) {
                _homeMenu.postValue(it.body())
            }else{
                _homeMenuError.postValue(it.message())
            }

        }

    }

    fun getAccNum() = viewModelScope.launch(Dispatchers.IO){
        _accNum.postValue((populateDataAccountNumber()))


    }


}