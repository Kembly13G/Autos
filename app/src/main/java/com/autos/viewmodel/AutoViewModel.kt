package com.autos.viewmodel

import android.app.Application
import androidx.lifecycle.*
import com.autos.data.AutoDatabase
import com.autos.model.Auto
import com.autos.repository.AutoRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class AutoViewModel (application : Application) : AndroidViewModel(application) {

    val getAllData: LiveData<List<Auto>>

    private val repository: AutoRepository

    init {
        val autoDao = AutoDatabase.getDatabase(application).autoDao()
        repository = AutoRepository(autoDao)
        getAllData = repository.getAllData
    }

    fun addAuto(auto: Auto) {
        viewModelScope.launch(Dispatchers.IO){
            repository.addAuto(auto)
        }
    }

    fun updateAuto(auto: Auto) {
        viewModelScope.launch(Dispatchers.IO){
            repository.updateAuto(auto)
        }
    }

    fun deleteLugar(auto: Auto) {
        viewModelScope.launch(Dispatchers.IO){
            repository.deleteAuto(auto)
        }
    }

}