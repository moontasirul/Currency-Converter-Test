package com.paypay.testApplication.data.repository

import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.paypay.testApplication.Quotes
import com.paypay.testApplication.data.local.database.dao.CurrencyDao
import com.paypay.testApplication.data.local.database.entity.CurrencyRate
import com.paypay.testApplication.data.local.prefs.AppPreferences
import com.paypay.testApplication.data.remote.dataSource.RemoteDataSource
import com.paypay.testApplication.data.remote.dataSource.baseDataSource.BaseDataSource
import com.paypay.testApplication.utils.performGetOperation
import dagger.hilt.android.scopes.ActivityRetainedScoped
import org.json.JSONArray
import org.json.JSONObject
import java.lang.reflect.Type
import javax.inject.Inject

@ActivityRetainedScoped
class AppRepository @Inject constructor(
    private var dataSource: RemoteDataSource,
    private var preferences: AppPreferences,
    private var localDataSource: CurrencyDao,

    ) : BaseDataSource() {

    fun getLiveCurrency() = performGetOperation(

        databaseQuery = { localDataSource.getAllCurrency() },
        networkCall = { dataSource.getAllLiveCurrency() },
        saveCallResult = { liveCurrency ->
            val myDataArray = Gson().toJson(liveCurrency.quotes)
            val currencyList = arrayListOf<CurrencyRate>()
            var rowCount = 0
            for (key in JSONObject(myDataArray).keys()) {
                val values = JSONObject(myDataArray).opt(key)
                currencyList.add(
                    CurrencyRate(
                        rowCount,
                        liveCurrency.timestamp,
                        key.substring(3).toString(),
                        values.toString()
                    )
                )
                rowCount += 1
            }
            localDataSource.insertAllCurrencyRate(currencyList)
        }
    )

}