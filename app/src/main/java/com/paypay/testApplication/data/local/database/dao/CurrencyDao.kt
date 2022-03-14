package com.paypay.testApplication.data.local.database.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.paypay.testApplication.data.local.database.entity.CurrencyRate

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currency_rate")
    fun getAllCurrency(): LiveData<List<CurrencyRate>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCurrencyRate(currency: List<CurrencyRate>)

    @Query("DELETE FROM currency_rate")
    fun removeAll()
}
