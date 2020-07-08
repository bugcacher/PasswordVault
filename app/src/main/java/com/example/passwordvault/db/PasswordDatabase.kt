package com.example.passwordvault.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.CardDetailsItem
import com.example.passwordvault.model.LoginDetailsItem
import com.example.passwordvault.ui.fragments.BankDetails

/**
 * Created by Abhinav Singh on 07,July,2020
 */
@Database(entities = [BankDetailsItem::class, LoginDetailsItem::class, CardDetailsItem::class],version = 5,exportSchema = false)
abstract class PasswordDatabase : RoomDatabase() {

    abstract fun bankDao() : BankDao

    abstract fun cardDao() : CardDao

    abstract fun loginDao() : LoginDao

}