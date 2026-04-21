package com.dicoding.cancersc.di

import android.content.Context
import com.dicoding.cancersc.data.local.AppDatabase
import com.dicoding.cancersc.data.repository.ResultRepository

object Injection {
    fun provideRepository(context: Context): ResultRepository {
        val database = AppDatabase.getDatabase(context)
        val dao = database.appDao()
        return ResultRepository.getInstance(dao)
    }
}