package com.paypay.testApplication.ui.currencyCalculator

import com.paypay.testApplication.data.domainModel.ConvertedCurrency
import com.paypay.testApplication.data.local.database.entity.CurrencyRate
import com.paypay.testApplication.ui.base.IBaseNavigator

interface ICurrencyCalculatorNavigator : IBaseNavigator {
    fun messageDialog(message: String)
    fun onShowList(convertedList : List<ConvertedCurrency>)
    fun setupObservers()
}