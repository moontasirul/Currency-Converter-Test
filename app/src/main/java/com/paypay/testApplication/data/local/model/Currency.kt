package com.paypay.testApplication

import com.google.gson.annotations.SerializedName
import org.json.JSONArray
import org.json.JSONObject


data class Currency (

  @SerializedName("success"   ) var success   : Boolean? = null,
  @SerializedName("terms"     ) var terms     : String?  = null,
  @SerializedName("privacy"   ) var privacy   : String?  = null,
  @SerializedName("timestamp" ) var timestamp : Int?     = null,
  @SerializedName("source"    ) var source    : String?  = null,
  @SerializedName("quotes"    ) var quotes    : Quotes?  = Quotes()
 // @SerializedName("quotes"    ) var quotes    : String? = null

)