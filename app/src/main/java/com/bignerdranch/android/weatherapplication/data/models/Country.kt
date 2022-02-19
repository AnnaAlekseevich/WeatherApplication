package com.bignerdranch.android.weatherapplication.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity
data class Country(

    @PrimaryKey
    @ColumnInfo(name = "countryName")
    var countryName: String,

    @ColumnInfo(name = "capitalName")
    var capitalName: String,

    @ColumnInfo(name = "imageResId")
    var imageResId: Int,

    )
