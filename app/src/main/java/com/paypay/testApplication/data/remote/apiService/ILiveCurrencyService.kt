package com.paypay.testApplication.data.remote.apiService

import com.paypay.testApplication.Currency
import com.paypay.testApplication.data.remote.ApiEndPoint.Companion.LIVE_CURRENCY_API
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ILiveCurrencyService {

    @GET(LIVE_CURRENCY_API)
    suspend fun getAllLiveCurrency(@Query("access_key") accessKey : String,
                                   @Query("format") format : Int): Response<Currency>
}