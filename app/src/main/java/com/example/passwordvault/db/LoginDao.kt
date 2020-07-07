package com.example.passwordvault.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.passwordvault.model.BankDetailsItem
import com.example.passwordvault.model.LoginDetailsItem

/**
 * Created by Abhinav Singh on 07,July,2020
 */

@Dao
interface LoginDao {

    @Insert
    fun insertLoginDetails(loginDetails : LoginDetailsItem)

    @Query("DELETE FROM LoginDetailsTable WHERE loginEmail = :email")
    fun deleteLoginDetails(email : String)

    @Query("SELECT * FROM PassManager")
    fun getAllLoginDetails() : LiveData<List<LoginDetailsItem>>

}