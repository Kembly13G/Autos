package com.autos.model

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName="auto")
data class Auto(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    @ColumnInfo(name="marca")
    val marca: String,
    @ColumnInfo(name="modelo")
    val modelo: String?,
    @ColumnInfo(name="color")
    val color: String?,
    @ColumnInfo(name="anualidad")
    val anualidad: String?,
    @ColumnInfo(name="placa")
    val placa: String?,
    @ColumnInfo(name="pais")
    val pais: String?,
    @ColumnInfo(name="plazas")
    val plazas: String?,
    @ColumnInfo(name="cilindraje")
    val cilindraje: String?,
) : Parcelable

