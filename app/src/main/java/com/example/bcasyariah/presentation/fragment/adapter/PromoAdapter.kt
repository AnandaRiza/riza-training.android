package com.example.bcasyariah.presentation.fragment.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bcasyariah.databinding.ItemAccountNumberBinding
import com.example.bcasyariah.databinding.ItemPromoBinding
import com.example.bcasyariah.model.AccountNumberModel
import com.example.bcasyariah.model.PromoModel

class PromoAdapter(
    private val data: List<PromoModel>
): RecyclerView.Adapter<PromoAdapter.PromoViewHolder> () {



    inner class PromoViewHolder(
        val binding: ItemPromoBinding
    ):RecyclerView.ViewHolder(binding.root){
        fun bind(data: PromoModel){
            binding.ivPromo.setImageResource(data.image)

        }
    }


    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): PromoAdapter.PromoViewHolder {
        return PromoViewHolder(
            ItemPromoBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    override fun onBindViewHolder(holder: PromoAdapter.PromoViewHolder, position: Int) {
        holder.bind(data[position])

    }

    override fun getItemCount(): Int = data.size

}