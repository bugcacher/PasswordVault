package com.example.passwordvault.repository

import androidx.lifecycle.LiveData
import com.example.passwordvault.db.BankDao
import com.example.passwordvault.db.CardDao
import com.example.passwordvault.db.LoginDao
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.CardDetailsItem
import com.example.passwordvault.model.LoginDetailsItem
import javax.inject.Inject

/**
 * Created by Abhinav Singh on 07,July,2020
 */

class Repository @Inject constructor(private val bankDao: BankDao, private val loginDao: LoginDao, private val cardDao: CardDao) {

    fun insertBankDetails(bankDetailsItem: BankDetailsItem){
      bankDao.insertBankDetails(bankDetailsItem)
    }

    fun deleteBankDetails(accountNumber: Long){
        bankDao.deleteBankDetails(accountNumber)
    }

    fun getAllBankDetails() : LiveData<List<BankDetailsItem>>{
        return bankDao.getAllBankDetails()
    }

    fun insertCardDetails(cardDetailsItem: CardDetailsItem){
        cardDao.insertCardDetails(cardDetailsItem)
    }

    fun deleteCardDetails(cardNumber: String){
        cardDao.deleteCardDetails(cardNumber)
    }

    fun getAllCardDetails() : LiveData<List<CardDetailsItem>>{
        return cardDao.getAllCardDetails()
    }

    fun insertLoginDetails(loginDetailsItem: LoginDetailsItem){
        loginDao.insertLoginDetails(loginDetailsItem)
    }

    fun deleteLoginDetails(email: String){
        loginDao.deleteLoginDetails(email)
    }

    fun getAllLoginDetails() : LiveData<List<LoginDetailsItem>>{
        return loginDao.getAllLoginDetails()
    }

    fun getCategoryLoginDetails(category : String) : LiveData<List<LoginDetailsItem>>{
        return loginDao.getCategoryLoginDetails(category)
    }


}