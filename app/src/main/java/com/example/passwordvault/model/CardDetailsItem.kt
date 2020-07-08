package com.example.passwordvault.model

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Created by Abhinav Singh on 01,July,2020
 */
@Entity(tableName = "CardDetailsTable")
data class CardDetailsItem(var cardHolder : String , var cardIssuer :String, @PrimaryKey var cardNumber :String, var cardExpiryMonth : String, var cardExpiryYear : String, var cardCvv : String) {

}