package com.example.bcasyariah.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class TransactionModel(
    val transferType: String,
    val transferDestination: String,
    val transferDate: String,
    val transferStatus: String,
    val amount: Double
) : Parcelable