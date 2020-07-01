package com.example.passwordvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abhinav Singh on 01,July,2020
 */
@Entity
class BankDetails(var bankName:String, @PrimaryKey var bankAccNumber : String, var bankIFSC : String, var bankAddress : String) {

}