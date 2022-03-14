package com.paypay.testApplication.utils.dialogUtils

import com.paypay.testApplication.ui.base.IBaseNavigator

interface IDialogNavigation : IBaseNavigator {
    fun onNext()
    fun onPositive()
    fun onCancel()
}