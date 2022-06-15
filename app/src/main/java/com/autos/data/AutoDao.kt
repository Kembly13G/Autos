package com.autos.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.autos.model.Auto

@Dao
interface AutoDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addAuto(auto : Auto)

    @Update(onConflict = OnConflictStrategy.IGNORE)
    suspend fun updateAuto(auto : Auto)

    @Delete
    suspend fun deleteAuto(auto : Auto)

    @Query("SELECT * FROM AUTO")
    fun getAllData() : LiveData<List<Auto>>
}