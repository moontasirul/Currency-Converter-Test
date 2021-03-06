package com.paypay.testApplication.data.local.database.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "currency_rate")
data class CurrencyRate(

    @PrimaryKey
    val id: Int,

    @ColumnInfo(name = "timestamp")
    var timestamp: Int? = null,

    @ColumnInfo(name = "currency_name")
    var currency: String? = null,

    @ColumnInfo(name = "currency_value")
    var currencyValue: String? = null,

//    @ColumnInfo(name = "USDAFN") var USDAFN: Double? = null,
//    @ColumnInfo(name = "USDALL") var USDALL: Double? = null,
//    @ColumnInfo(name = "USDAMD") var USDAMD: Double? = null,
//    @ColumnInfo(name = "USDANG") var USDANG: Double? = null,
//    @ColumnInfo(name = "USDAOA") var USDAOA: Double? = null,
//    @ColumnInfo(name = "USDARS") var USDARS: Double? = null,
//    @ColumnInfo(name = "USDAUD") var USDAUD: Double? = null,
//    @ColumnInfo(name = "USDAWG") var USDAWG: Double? = null,
//    @ColumnInfo(name = "USDAZN") var USDAZN: Double? = null,
//    @ColumnInfo(name = "USDBAM") var USDBAM: Double? = null,
//    @ColumnInfo(name = "USDBBD") var USDBBD: Double? = null,
//    @ColumnInfo(name = "USDBDT") var USDBDT: Double? = null,
//    @ColumnInfo(name = "USDBGN") var USDBGN: Double? = null,
//    @ColumnInfo(name = "USDBHD") var USDBHD: Double? = null,
//    @ColumnInfo(name = "USDBIF") var USDBIF: Double? = null,
//    @ColumnInfo(name = "USDBMD") var USDBMD: Double? = null,
//    @ColumnInfo(name = "USDBND") var USDBND: Double? = null,
//    @ColumnInfo(name = "USDBOB") var USDBOB: Double? = null,
//    @ColumnInfo(name = "USDBRL") var USDBRL: Double? = null,
//    @ColumnInfo(name = "USDBSD") var USDBSD: Double? = null,
//    @ColumnInfo(name = "USDBTC") var USDBTC: Double? = null,
//    @ColumnInfo(name = "USDBTN") var USDBTN: Double? = null,
//    @ColumnInfo(name = "USDBWP") var USDBWP: Double? = null,
//    @ColumnInfo(name = "USDBYN") var USDBYN: Double? = null,
//    @ColumnInfo(name = "USDBYR") var USDBYR: Double? = null,
//    @ColumnInfo(name = "USDBZD") var USDBZD: Double? = null,
//    @ColumnInfo(name = "USDCAD") var USDCAD: Double? = null,
//    @ColumnInfo(name = "USDCDF") var USDCDF: Double? = null,
//    @ColumnInfo(name = "USDCHF") var USDCHF: Double? = null,
//    @ColumnInfo(name = "USDCLF") var USDCLF: Double? = null,
//    @ColumnInfo(name = "USDCLP") var USDCLP: Double? = null,
//    @ColumnInfo(name = "USDCNY") var USDCNY: Double? = null,
//    @ColumnInfo(name = "USDCOP") var USDCOP: Double? = null,
//    @ColumnInfo(name = "USDCRC") var USDCRC: Double? = null,
//    @ColumnInfo(name = "USDCUC") var USDCUC: Double? = null,
//    @ColumnInfo(name = "USDCUP") var USDCUP: Double? = null,
//    @ColumnInfo(name = "USDCVE") var USDCVE: Double? = null,
//    @ColumnInfo(name = "USDCZK") var USDCZK: Double? = null,
//    @ColumnInfo(name = "USDDJF") var USDDJF: Double? = null,
//    @ColumnInfo(name = "USDDKK") var USDDKK: Double? = null,
//    @ColumnInfo(name = "USDDOP") var USDDOP: Double? = null,
//    @ColumnInfo(name = "USDDZD") var USDDZD: Double? = null,
//    @ColumnInfo(name = "USDEGP") var USDEGP: Double? = null,
//    @ColumnInfo(name = "USDERN") var USDERN: Double? = null,
//    @ColumnInfo(name = "USDETB") var USDETB: Double? = null,
//    @ColumnInfo(name = "USDEUR") var USDEUR: Double? = null,
//    @ColumnInfo(name = "USDFJD") var USDFJD: Double? = null,
//    @ColumnInfo(name = "USDFKP") var USDFKP: Double? = null,
//    @ColumnInfo(name = "USDGBP") var USDGBP: Double? = null,
//    @ColumnInfo(name = "USDGEL") var USDGEL: Double? = null,
//    @ColumnInfo(name = "USDGGP") var USDGGP: Double? = null,
//    @ColumnInfo(name = "USDGHS") var USDGHS: Double? = null,
//    @ColumnInfo(name = "USDGIP") var USDGIP: Double? = null,
//    @ColumnInfo(name = "USDGMD") var USDGMD: Double? = null,
//    @ColumnInfo(name = "USDGNF") var USDGNF: Double? = null,
//    @ColumnInfo(name = "USDGTQ") var USDGTQ: Double? = null,
//    @ColumnInfo(name = "USDGYD") var USDGYD: Double? = null,
//    @ColumnInfo(name = "USDHKD") var USDHKD: Double? = null,
//    @ColumnInfo(name = "USDHNL") var USDHNL: Double? = null,
//    @ColumnInfo(name = "USDHRK") var USDHRK: Double? = null,
//    @ColumnInfo(name = "USDHTG") var USDHTG: Double? = null,
//    @ColumnInfo(name = "USDHUF") var USDHUF: Double? = null,
//    @ColumnInfo(name = "USDIDR") var USDIDR: Double? = null,
//    @ColumnInfo(name = "USDILS") var USDILS: Double? = null,
//    @ColumnInfo(name = "USDIMP") var USDIMP: Double? = null,
//    @ColumnInfo(name = "USDINR") var USDINR: Double? = null,
//    @ColumnInfo(name = "USDIQD") var USDIQD: Double? = null,
//    @ColumnInfo(name = "USDIRR") var USDIRR: Double? = null,
//    @ColumnInfo(name = "USDISK") var USDISK: Double? = null,
//    @ColumnInfo(name = "USDJEP") var USDJEP: Double? = null,
//    @ColumnInfo(name = "USDJMD") var USDJMD: Double? = null,
//    @ColumnInfo(name = "USDJOD") var USDJOD: Double? = null,
//    @ColumnInfo(name = "USDJPY") var USDJPY: Double? = null,
//    @ColumnInfo(name = "USDKES") var USDKES: Double? = null,
//    @ColumnInfo(name = "USDKGS") var USDKGS: Double? = null,
//    @ColumnInfo(name = "USDKHR") var USDKHR: Double? = null,
//    @ColumnInfo(name = "USDKMF") var USDKMF: Double? = null,
//    @ColumnInfo(name = "USDKPW") var USDKPW: Double? = null,
//    @ColumnInfo(name = "USDKRW") var USDKRW: Double? = null,
//    @ColumnInfo(name = "USDKWD") var USDKWD: Double? = null,
//    @ColumnInfo(name = "USDKYD") var USDKYD: Double? = null,
//    @ColumnInfo(name = "USDKZT") var USDKZT: Double? = null,
//    @ColumnInfo(name = "USDLAK") var USDLAK: Double? = null,
//    @ColumnInfo(name = "USDLBP") var USDLBP: Double? = null,
//    @ColumnInfo(name = "USDLKR") var USDLKR: Double? = null,
//    @ColumnInfo(name = "USDLRD") var USDLRD: Double? = null,
//    @ColumnInfo(name = "USDLSL") var USDLSL: Double? = null,
//    @ColumnInfo(name = "USDLTL") var USDLTL: Double? = null,
//    @ColumnInfo(name = "USDLVL") var USDLVL: Double? = null,
//    @ColumnInfo(name = "USDLYD") var USDLYD: Double? = null,
//    @ColumnInfo(name = "USDMAD") var USDMAD: Double? = null,
//    @ColumnInfo(name = "USDMDL") var USDMDL: Double? = null,
//    @ColumnInfo(name = "USDMGA") var USDMGA: Double? = null,
//    @ColumnInfo(name = "USDMKD") var USDMKD: Double? = null,
//    @ColumnInfo(name = "USDMMK") var USDMMK: Double? = null,
//    @ColumnInfo(name = "USDMNT") var USDMNT: Double? = null,
//    @ColumnInfo(name = "USDMOP") var USDMOP: Double? = null,
//    @ColumnInfo(name = "USDMRO") var USDMRO: Double? = null,
//    @ColumnInfo(name = "USDMUR") var USDMUR: Double? = null,
//    @ColumnInfo(name = "USDMVR") var USDMVR: Double? = null,
//    @ColumnInfo(name = "USDMWK") var USDMWK: Double? = null,
//    @ColumnInfo(name = "USDMXN") var USDMXN: Double? = null,
//    @ColumnInfo(name = "USDMYR") var USDMYR: Double? = null,
//    @ColumnInfo(name = "USDMZN") var USDMZN: Double? = null,
//    @ColumnInfo(name = "USDNAD") var USDNAD: Double? = null,
//    @ColumnInfo(name = "USDNGN") var USDNGN: Double? = null,
//    @ColumnInfo(name = "USDNIO") var USDNIO: Double? = null,
//    @ColumnInfo(name = "USDNOK") var USDNOK: Double? = null,
//    @ColumnInfo(name = "USDNPR") var USDNPR: Double? = null,
//    @ColumnInfo(name = "USDNZD") var USDNZD: Double? = null,
//    @ColumnInfo(name = "USDOMR") var USDOMR: Double? = null,
//    @ColumnInfo(name = "USDPAB") var USDPAB: Double? = null,
//    @ColumnInfo(name = "USDPEN") var USDPEN: Double? = null,
//    @ColumnInfo(name = "USDPGK") var USDPGK: Double? = null,
//    @ColumnInfo(name = "USDPHP") var USDPHP: Double? = null,
//    @ColumnInfo(name = "USDPKR") var USDPKR: Double? = null,
//    @ColumnInfo(name = "USDPLN") var USDPLN: Double? = null,
//    @ColumnInfo(name = "USDPYG") var USDPYG: Double? = null,
//    @ColumnInfo(name = "USDQAR") var USDQAR: Double? = null,
//    @ColumnInfo(name = "USDRON") var USDRON: Double? = null,
//    @ColumnInfo(name = "USDRSD") var USDRSD: Double? = null,
//    @ColumnInfo(name = "USDRUB") var USDRUB: Double? = null,
//    @ColumnInfo(name = "USDRWF") var USDRWF: Double? = null,
//    @ColumnInfo(name = "USDSAR") var USDSAR: Double? = null,
//    @ColumnInfo(name = "USDSBD") var USDSBD: Double? = null,
//    @ColumnInfo(name = "USDSCR") var USDSCR: Double? = null,
//    @ColumnInfo(name = "USDSDG") var USDSDG: Double? = null,
//    @ColumnInfo(name = "USDSEK") var USDSEK: Double? = null,
//    @ColumnInfo(name = "USDSGD") var USDSGD: Double? = null,
//    @ColumnInfo(name = "USDSHP") var USDSHP: Double? = null,
//    @ColumnInfo(name = "USDSLL") var USDSLL: Double? = null,
//    @ColumnInfo(name = "USDSOS") var USDSOS: Double? = null,
//    @ColumnInfo(name = "USDSRD") var USDSRD: Double? = null,
//    @ColumnInfo(name = "USDSTD") var USDSTD: Double? = null,
//    @ColumnInfo(name = "USDSVC") var USDSVC: Double? = null,
//    @ColumnInfo(name = "USDSYP") var USDSYP: Double? = null,
//    @ColumnInfo(name = "USDSZL") var USDSZL: Double? = null,
//    @ColumnInfo(name = "USDTHB") var USDTHB: Double? = null,
//    @ColumnInfo(name = "USDTJS") var USDTJS: Double? = null,
//    @ColumnInfo(name = "USDTMT") var USDTMT: Double? = null,
//    @ColumnInfo(name = "USDTND") var USDTND: Double? = null,
//    @ColumnInfo(name = "USDTOP") var USDTOP: Double? = null,
//    @ColumnInfo(name = "USDTRY") var USDTRY: Double? = null,
//    @ColumnInfo(name = "USDTTD") var USDTTD: Double? = null,
//    @ColumnInfo(name = "USDTWD") var USDTWD: Double? = null,
//    @ColumnInfo(name = "USDTZS") var USDTZS: Double? = null,
//    @ColumnInfo(name = "USDUAH") var USDUAH: Double? = null,
//    @ColumnInfo(name = "USDUGX") var USDUGX: Double? = null,
//    @ColumnInfo(name = "USDUSD") var USDUSD: Double? = null,
//    @ColumnInfo(name = "USDUYU") var USDUYU: Double? = null,
//    @ColumnInfo(name = "USDUZS") var USDUZS: Double? = null,
//    @ColumnInfo(name = "USDVEF") var USDVEF: Double? = null,
//    @ColumnInfo(name = "USDVND") var USDVND: Double? = null,
//    @ColumnInfo(name = "USDVUV") var USDVUV: Double? = null,
//    @ColumnInfo(name = "USDWST") var USDWST: Double? = null,
//    @ColumnInfo(name = "USDXAF") var USDXAF: Double? = null,
//    @ColumnInfo(name = "USDXAG") var USDXAG: Double? = null,
//    @ColumnInfo(name = "USDXAU") var USDXAU: Double? = null,
//    @ColumnInfo(name = "USDXCD") var USDXCD: Double? = null,
//    @ColumnInfo(name = "USDXDR") var USDXDR: Double? = null,
//    @ColumnInfo(name = "USDXOF") var USDXOF: Double? = null,
//    @ColumnInfo(name = "USDXPF") var USDXPF: Double? = null,
//    @ColumnInfo(name = "USDYER") var USDYER: Double? = null,
//    @ColumnInfo(name = "USDZAR") var USDZAR: Double? = null,
//    @ColumnInfo(name = "USDZMK") var USDZMK: Double? = null,
//    @ColumnInfo(name = "USDZMW") var USDZMW: Double? = null,
//    @ColumnInfo(name = "USDZWL") var USDZWL: Double? = null
)
