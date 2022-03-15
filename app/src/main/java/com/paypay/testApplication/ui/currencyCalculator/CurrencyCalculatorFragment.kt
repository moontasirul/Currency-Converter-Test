package com.paypay.testApplication.ui.currencyCalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.paypay.testApplication.R
import com.paypay.testApplication.data.domainModel.ConvertedCurrency
import com.paypay.testApplication.databinding.FragmentCurrencyCalculatorBinding
import com.paypay.testApplication.utils.CustomSwipeRefreshLayout
import com.paypay.testApplication.utils.dialogUtils.CustomDialogCallback
import com.paypay.testApplication.utils.dialogUtils.CustomDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CurrencyCalculatorFragment : Fragment(),
    ICurrencyCalculatorNavigator, CustomSwipeRefreshLayout.Event {

    private lateinit var currencyBinding: FragmentCurrencyCalculatorBinding
    private val viewModel by viewModels<CurrencyCalculatorViewModel>()
    private lateinit var convertedCurrencyAdapter: ConvertedCurrencyRecyclerViewAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        currencyBinding = FragmentCurrencyCalculatorBinding.inflate(layoutInflater)
        currencyBinding.lifecycleOwner = this
        currencyBinding.currencyCalculatorViewModel = viewModel
        currencyBinding.fragmentSwipeContainer.setEventListener(this)
        return currencyBinding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.setNavigator(this)
        viewModel.isLoading.value = true
        setupObservers()
        viewModel.startUpdates()
    }


    override fun setupObservers() {
        viewModel.currencyResponse.observe(requireActivity()) { response ->
            viewModel.getCurrencyResponse(response)
            setupCurrencyList()
        }
    }



    override fun messageDialog(message: String) {
        showDialog(requireContext().resources.getString(R.string.msg_failed_title), message, true)
    }

    fun showDialog(title: String, message: String, isOnlyPositive: Boolean) {
        var dialog: DialogFragment? = null
        var bntText = requireContext().getString(R.string.yes_txt)
        if (isOnlyPositive) {
            bntText = requireContext().getString(R.string.btn_text_ok)
        }
        dialog = CustomDialogFragment(
            title,
            message,
            bntText,
            requireContext().getString(R.string.cancel_text),
            object : CustomDialogCallback {
                override fun onNextClick() {
                    dialog?.dismiss()
                }

                override fun onPositiveClick() {
                    dialog?.dismiss()
                }

                override fun onCloseClick() {
                    dialog?.dismiss()
                }
            },
            isOnlyPositive,
        )
        dialog.show(childFragmentManager, "DIALOG_TAG")
    }


    fun setupCurrencyList() {
        activity?.let {
            val cList = viewModel.prepareCurrencyNameList()
            val adapter =
                ArrayAdapter<String>(it, android.R.layout.simple_spinner_dropdown_item, cList)
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            currencyBinding.currencyListSpinner.adapter = adapter

            currencyBinding?.currencyListSpinner?.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }

                    override fun onItemSelected(
                        parent: AdapterView<*>?,
                        view: View?,
                        position: Int,
                        id: Long
                    ) {
                        val itemName = parent?.getItemAtPosition(position)
                        viewModel.tvCurrencyName.value = itemName.toString()
                    }

                }
        }
    }

    override fun onRefresh(view: CustomSwipeRefreshLayout) {
        setupObservers()
    }


    override fun onShowList(convertedList: List<ConvertedCurrency>) {
        viewModel.isDataFetching.set(true)
        convertedCurrencyAdapter = ConvertedCurrencyRecyclerViewAdapter()
        currencyBinding.convertedCurrencyRecyclerView.adapter = convertedCurrencyAdapter
        convertedCurrencyAdapter.clearItems()
        convertedCurrencyAdapter.addItems(convertedList)
    }

}




