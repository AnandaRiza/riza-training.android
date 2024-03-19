package com.example.bcasyariah.presentation

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.bcasyariah.R
import com.example.bcasyariah.databinding.ActivityDetailTransactionBinding
import com.example.bcasyariah.model.TransactionModel
import com.example.bcasyariah.presentation.ListTransactionActivity.Companion.TRANSACTION_KEY

class DetailTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailTransactionBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val transaction = intent.getParcelableExtra<TransactionModel>(TRANSACTION_KEY)
        binding.tvTransferDate.text = transaction?.transferDate
        binding.tvTransferAmount.text = transaction?.amount.toString()
        binding.tvTransferType.text = transaction?.transferType
        binding.tvTransferStatus.text = transaction?.transferStatus
        binding.tvTransferDestination.text = transaction?.transferDestination

    }
}