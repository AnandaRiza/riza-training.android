package com.example.bcasyariah.presentation

import android.content.Intent
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bcasyariah.adapter.ListTransactionAdapter
import com.example.bcasyariah.databinding.ActivityListTransactionBinding
import com.example.bcasyariah.databinding.ActivityLoginBinding
import com.example.bcasyariah.model.TransactionModel


class ListTransactionActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListTransactionBinding

    private var listTransactionAdapter = ListTransactionAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListTransactionBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.rvListTransaction.adapter = listTransactionAdapter
        listTransactionAdapter.setData(createDummyListTransaction())

        listTransactionAdapter.setOnClickTransaction { transaction ->
           navigateToDetailTransaction(transaction)
        }


    }

    private fun navigateToDetailTransaction(data:TransactionModel){
        val intent = Intent(this, DetailTransactionActivity::class.java)
        intent.putExtra(TRANSACTION_KEY, data)
        startActivity(intent)
    }

    private fun createDummyListTransaction() : MutableList<TransactionModel>{
        return mutableListOf(
            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "GOPAY",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 20000.0
            ),

            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Transfer",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Top up OVO",
                transferDestination = "OVO",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Top up",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran qew",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran bca",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran sda",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran msd",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran cvc",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran qwwq",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

            TransactionModel(
                transferType = "Pembayaran QR",
                transferDestination = "Mandiri",
                transferDate = "02/02/24",
                transferStatus = "SUKSES",
                amount = 40000.0
            ),

        )



    }

    companion object {
        const val TRANSACTION_KEY = "transaction_key"
    }


}