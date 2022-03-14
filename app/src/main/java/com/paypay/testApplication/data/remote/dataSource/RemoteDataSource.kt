package com.paypay.testApplication.data.remote.dataSource

import com.paypay.testApplication.data.remote.ApiEndPoint.Companion.ACCESS_KEY
import com.paypay.testApplication.data.remote.apiService.ILiveCurrencyService
import com.paypay.testApplication.data.remote.dataSource.baseDataSource.BaseDataSource
import javax.inject.Inject

class RemoteDataSource @Inject constructor(
    private val liveCurrencyService: ILiveCurrencyService
) : BaseDataSource() {
    suspend fun getAllLiveCurrency() = getResult { liveCurrencyService.getAllLiveCurrency(ACCESS_KEY, 1) }
}