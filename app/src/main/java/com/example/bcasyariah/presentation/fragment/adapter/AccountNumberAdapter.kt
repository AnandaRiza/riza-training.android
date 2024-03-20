package com.example.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.lifecycle.ComputableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemAccountNumberBinding
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.TransactionModel

class AccountNumberAdapter(
    private val data: List<AccountNumberModel>
): RecyclerView.Adapter<AccountNumberAdapter.AccountNumberViewHolder> () {


    inner class AccountNumberViewHolder(
        val binding: ItemAccountNumberBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(data: AccountNumberModel){
            binding.tvSavingType.text = data.savingType.toString()
            binding.tvAccountNumber.text = data.accNumber.toString()
            binding.tvAccountBalance.text = data.ballanceAmount

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountNumberViewHolder {
        return AccountNumberViewHolder(
            ItemAccountNumberBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = data.size

    override fun onBindViewHolder(holder: AccountNumberViewHolder, position: Int) {
        holder.bind(data[position])

    }


}