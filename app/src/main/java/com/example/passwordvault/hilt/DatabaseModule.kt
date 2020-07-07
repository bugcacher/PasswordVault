package com.example.passwordvault.hilt

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.passwordvault.db.BankDao
import com.example.passwordvault.db.CardDao
import com.example.passwordvault.db.LoginDao
import com.example.passwordvault.db.PasswordDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

/**
 * Created by Abhinav Singh on 07,July,2020
 */
@Module
@InstallIn(ApplicationComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(application : Application) : PasswordDatabase{
        return Room.databaseBuilder(application,PasswordDatabase::class.java,"MyDatabase")
            .fallbackToDestructiveMigration()
            .allowMainThreadQueries()
            .build()
    }

    @Provides
    fun provideBankDao(passwordDatabase: PasswordDatabase) : BankDao{
        return passwordDatabase.bankDao()
    }

    @Provides
    fun provideLoginDao(passwordDatabase: PasswordDatabase) : LoginDao{
        return passwordDatabase.loginDao()
    }

    @Provides
    fun provideCardDao(passwordDatabase: PasswordDatabase) : CardDao{
        return passwordDatabase.cardDao()
    }
}