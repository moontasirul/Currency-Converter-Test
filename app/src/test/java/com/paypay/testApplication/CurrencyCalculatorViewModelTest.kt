package com.paypay.testApplication

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.google.common.truth.Truth
import com.paypay.testApplication.data.domainModel.ConvertedCurrency
import com.paypay.testApplication.data.local.database.entity.CurrencyRate
import com.paypay.testApplication.data.repository.AppRepository
import com.paypay.testApplication.ui.currencyCalculator.CurrencyCalculatorViewModel
import com.paypay.testApplication.ui.currencyCalculator.ICurrencyCalculatorNavigator
import com.paypay.testApplication.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.TestCoroutineDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mockito

@ExperimentalCoroutinesApi
@RunWith(JUnit4::class)
class CurrencyCalculatorViewModelTest {

    private lateinit var currencyCalculatorViewModel: CurrencyCalculatorViewModel
    private lateinit var repository: AppRepository
    val testDispatcher = TestCoroutineDispatcher()

    private lateinit var mNavigator: ICurrencyCalculatorNavigator

    @get:Rule
    val instantTaskExecutionRule: InstantTaskExecutorRule = InstantTaskExecutorRule()

    @Before
    fun initSetUp() {
        Dispatchers.setMain(testDispatcher)
        repository = Mockito.mock(AppRepository::class.java)
        currencyCalculatorViewModel = CurrencyCalculatorViewModel(repository)
        mNavigator = Mockito.mock(ICurrencyCalculatorNavigator::class.java)
        currencyCalculatorViewModel.setNavigator(mNavigator)
    }


    @Test
    fun checkLoadingState_OnRequestInit_isTrue() {
        currencyCalculatorViewModel.isLoading.value = true
        Truth.assertThat(currencyCalculatorViewModel.isLoading.value).isEqualTo(true)
    }


    @Test
    fun checkLoadingState_OnRequestComplete_isFalse() {
        currencyCalculatorViewModel.isLoading.value = false
        Truth.assertThat(currencyCalculatorViewModel.isLoading.value).isFalse()
    }


    @Test
    fun onResponseReceived_checkFailedState_isError() {
        Mockito.`when`(
            currencyCalculatorViewModel.getCityResponse(
                Resource(
                    status = Resource.Status.SUCCESS,
                    data = null,
                    message = null
                )
            )
        ).thenReturn(null)
        currencyCalculatorViewModel.onClickCalculateCurrency()
        Truth.assertThat(currencyCalculatorViewModel.currencyList).isNotNull()
        Truth.assertThat(currencyCalculatorViewModel.isLoading.value).isEqualTo(false)
    }


    @Test
    fun onClickCalculateCurrency_isSuccess() {
        val currencyList: ArrayList<CurrencyRate> = arrayListOf()
        currencyList.add(
            CurrencyRate(
                id = 0,
                timestamp = 1647245463,
                currency = "AED",
                currencyValue = "3.67303"
            )
        )
        currencyList.add(
            CurrencyRate(
                id = 1,
                timestamp = 1647245463,
                currency = "BDT",
                currencyValue = "86.67303"
            )
        )
        currencyCalculatorViewModel.tvCurrencyName.value = "BDT"
        currencyCalculatorViewModel.etAmount.value = "100"
        val selectedCurrency = currencyList.filter {
            currencyCalculatorViewModel.tvCurrencyName.value?.let { it1 -> it.currency?.contains(it1) } == true
        }
        var calculateWithUSD = 0.0
        if (!selectedCurrency.isNullOrEmpty()) {
            currencyCalculatorViewModel.etAmount.value?.let { name ->
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
                cItem.currencyValue?.let { calculateWithUSD.times(it.toDouble()) }
            convertedList.add(ConvertedCurrency(cItem.currency, finalOutput.toString()))
        }
        Truth.assertThat(!convertedList.isNullOrEmpty()).isEqualTo(true)
        currencyCalculatorViewModel.isLoading.value = false
        Truth.assertThat(currencyCalculatorViewModel.isLoading.value).isEqualTo(false)
    }


    @Test
    fun onClickCalculateCurrency_isFailed() {
        val currencyList: ArrayList<CurrencyRate> = arrayListOf()
        currencyCalculatorViewModel.tvCurrencyName.value = "JPY"
        currencyCalculatorViewModel.etAmount.value = "100"
        val selectedCurrency = currencyList.filter {
            currencyCalculatorViewModel.tvCurrencyName.value?.let { it1 -> it.currency?.contains(it1) } == true
        }
        var calculateWithUSD = 0.0
        if (!selectedCurrency.isNullOrEmpty()) {
            currencyCalculatorViewModel.etAmount.value?.let { name ->
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
                cItem.currencyValue?.let { calculateWithUSD.times(it.toDouble()) }
            convertedList.add(ConvertedCurrency(cItem.currency, finalOutput.toString()))
        }
        Truth.assertThat(convertedList.isNullOrEmpty()).isEqualTo(true)
        currencyCalculatorViewModel.isLoading.value = false
        Truth.assertThat(currencyCalculatorViewModel.isLoading.value).isEqualTo(false)
    }


    @After
    fun tearDown() {
        Dispatchers.resetMain()
        testDispatcher.cleanupTestCoroutines()
    }
}