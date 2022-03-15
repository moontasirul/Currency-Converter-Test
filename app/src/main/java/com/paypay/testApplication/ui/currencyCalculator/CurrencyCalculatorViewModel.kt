package com.paypay.testApplication.ui.currencyCalculator

import androidx.databinding.ObservableField
import androidx.lifecycle.MutableLiveData
import com.paypay.testApplication.data.domainModel.ConvertedCurrency
import com.paypay.testApplication.data.local.database.entity.CurrencyRate
import com.paypay.testApplication.data.repository.AppRepository
import com.paypay.testApplication.ui.base.BaseViewModel
import com.paypay.testApplication.utils.AppEnum
import com.paypay.testApplication.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.concurrent.TimeUnit
import javax.inject.Inject


@HiltViewModel
class CurrencyCalculatorViewModel @Inject constructor(
    private val repository: AppRepository
) : BaseViewModel<ICurrencyCalculatorNavigator>() {

    var isDataFetching = ObservableField(false)

    var currencyResponse = repository.getLiveCurrency()

    var currencyList: ArrayList<CurrencyRate> = arrayListOf()

    var etAmount = MutableLiveData<String>()
    var tvCurrencyName = MutableLiveData<String>()

    fun getCityResponse(response: Resource<List<CurrencyRate>>) {
        isLoading.value = true
        when (response.status.name) {
            AppEnum.API_CALL_STATUS.SUCCESS.name -> {
                response.data?.let {
                    if (currencyList.isNotEmpty()) {
                        currencyList.clear()
                    }
                    currencyList.addAll(it)
                }
                isLoading.value = false
            }
            AppEnum.API_CALL_STATUS.ERROR.name -> {
                isLoading.value = false
                response.message?.let { navigator.messageDialog(it) }
            }
            AppEnum.API_CALL_STATUS.LOADING.name -> {
                isLoading.value = true
            }
        }
    }


    fun prepareCurrencyNameList(): List<String> {
        val tempList = arrayListOf<String>()
        for (item in currencyList) {
            item.currency?.let { tempList.add(it) }
        }
        return tempList
    }


    fun onClickCalculateCurrency() {
        if (etAmount.value?.startsWith("0") == true || etAmount.value.isNullOrEmpty()) {
            navigator.messageDialog("Please Enter Valid Amount")
        } else {
            isLoading.value = true
            val selectedCurrency = currencyList.filter {
                tvCurrencyName.value?.let { it1 -> it.currency?.contains(it1) } == true
            }
            var calculateWithUSD = 0.0
            if (!selectedCurrency.isNullOrEmpty()) {
                etAmount.value?.let { name ->
                    selectedCurrency[0].currencyValue?.toDouble()?.let {
                        name.toDouble().div(it)
                    }
                }?.let {
                    calculateWithUSD = it
                }
            }

            val convertedList = arrayListOf<ConvertedCurrency>()
            for (cItem in currencyList) {
                val finalOutput =
                    cItem.currencyValue?.let { calculateWithUSD?.times(it.toDouble()) }
                convertedList.add(ConvertedCurrency(cItem.currency, finalOutput.toString()))
            }
            navigator.onShowList(convertedList)
            isLoading.value = false
        }
    }

    var job: Job? = null
    fun startUpdates() {
        stopUpdates()
        job = MainScope().launch {
            while(true) {
                navigator.setupObservers()
                delay(TimeUnit.MINUTES.toMillis(30))
            }
        }
    }

    private fun stopUpdates() {
        job?.cancel()
        job = null
    }
}

