package com.autos.repository

import androidx.lifecycle.LiveData
import com.autos.data.AutoDao
import com.autos.model.Auto

class AutoRepository (private val autoDao: AutoDao) {

    val getAllData: LiveData<List<Auto>> = autoDao.getAllData()

    suspend fun addAuto(auto:Auto) {
        autoDao.addAuto(auto)
    }

    suspend fun updateAuto(auto:Auto) {
        autoDao.updateAuto(auto)
    }

    suspend fun deleteAuto(auto:Auto) {
        autoDao.deleteAuto(auto)
    }
}