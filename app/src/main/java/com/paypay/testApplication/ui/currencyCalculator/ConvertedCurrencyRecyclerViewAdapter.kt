package com.paypay.testApplication.ui.currencyCalculator

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.paypay.testApplication.data.domainModel.ConvertedCurrency
import com.paypay.testApplication.data.local.database.entity.CurrencyRate
import com.paypay.testApplication.databinding.LayoutCurrencyItemBinding
import com.paypay.testApplication.ui.base.BaseViewHolder

class ConvertedCurrencyRecyclerViewAdapter() :
    RecyclerView.Adapter<ConvertedCurrencyRecyclerViewAdapter.ConvertedCurrencyViewHolder>() {

    private var currencyRateList: ArrayList<ConvertedCurrency> = arrayListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ConvertedCurrencyViewHolder {

        val binding: LayoutCurrencyItemBinding =
            LayoutCurrencyItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )

        return ConvertedCurrencyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ConvertedCurrencyViewHolder, position: Int) {
        holder.onBind(position)
    }

    override fun getItemCount(): Int {
        return currencyRateList.size
    }


    @SuppressLint("NotifyDataSetChanged")
    fun addItems(list: List<ConvertedCurrency>) {
        currencyRateList.addAll(list)
        notifyDataSetChanged()
    }


    fun clearItems() {
        currencyRateList.clear()
    }


    /**
     * Adapter Listener
     */
    interface CityItemAdapterListener {
        fun onCityContent(mCityListModel: CurrencyRate)
        fun onRetryClick()
    }

    inner class ConvertedCurrencyViewHolder(
        itemViewBinding: LayoutCurrencyItemBinding
    ) : BaseViewHolder(itemViewBinding.root) {
        private val mBinding: LayoutCurrencyItemBinding = itemViewBinding
        private var mCurrencyItemViewModel: CurrencyItemViewModel? = null

        override fun onBind(position: Int) {
            val mCurrencyRateModel: ConvertedCurrency = currencyRateList[position]
            mCurrencyItemViewModel =
                CurrencyItemViewModel(
                    position,
                    mCurrencyRateModel
                )
            mBinding.currencyItemViewModel = mCurrencyItemViewModel
            mBinding.executePendingBindings()
        }
    }


}