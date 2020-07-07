package com.example.passwordvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abhinav Singh on 01,July,2020
 */
@Entity(tableName = "BankDetailsTable")
data class BankDetailsItem(var bankName:String, @PrimaryKey var bankAccNumber : Long, var bankIFSC : String, var bankAddress : String) {

}