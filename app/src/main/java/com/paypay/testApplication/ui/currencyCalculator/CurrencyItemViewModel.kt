package com.paypay.testApplication.ui.currencyCalculator

import androidx.lifecycle.MutableLiveData
import com.paypay.testApplication.data.domainModel.ConvertedCurrency
import com.paypay.testApplication.data.local.database.entity.CurrencyRate

class CurrencyItemViewModel(
    position: Int,
    mCurrencyRateItemModel: ConvertedCurrency
) {
    var currencyName: MutableLiveData<String> = MutableLiveData(mCurrencyRateItemModel.currencyName)
    var currencyValue: MutableLiveData<String> = MutableLiveData(mCurrencyRateItemModel.currencyValue)

}