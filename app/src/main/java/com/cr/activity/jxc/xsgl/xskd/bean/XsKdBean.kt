package com.cr.activity.jxc.xsgl.xskd.bean

import com.google.gson.annotations.SerializedName

data class XsKdBean(

        @SerializedName("invoiceid") var invoiceid: String = "",
        @SerializedName("itemno") var itemno: String = "",
        @SerializedName("goodsid") var goodsid: String = "",
        @SerializedName("unitid") var unitid: String = "",
        @SerializedName("disc") var disc: String = "",
        @SerializedName("unitprice") var unitprice: String = "",
        @SerializedName("taxrate") var taxrate: String = "",
        @SerializedName("taxunitprice") var taxunitprice: String = "",
        @SerializedName("unitqty") var unitqty: String = "",
        @SerializedName("batchrefid") var batchrefid: String = "",
        @SerializedName("batchcode") var batchcode: String = "",
        @SerializedName("produceddate") var produceddate: String = "",
        @SerializedName("validdate") var validdate: String = "",
        @SerializedName("amount") var amount: String = "",
        @SerializedName("refertype") var refertype: String = "",
        @SerializedName("referbillid") var referbillid: String = "",
        @SerializedName("referitemno") var referitemno: String = "",
        @SerializedName("ispresent") var ispresent: String = "",
        @SerializedName("goodscode") var goodscode: String = "",
        @SerializedName("goodsname") var goodsname: String = "",
        @SerializedName("specs") var specs: String = "",
        @SerializedName("model") var model: String = "",
        @SerializedName("batchctrl") var batchctrl: String = "",
        @SerializedName("unitname") var unitname: String = "",
        @SerializedName("batchctrl1") var batchctrl1: String = "",
        @SerializedName("serialctrl") var serialctrl: String = "",
        @SerializedName("onhand") var onhand: String = "",
        @SerializedName("serialinfo") var serialinfo: String = "",
        @SerializedName("memo") var memo: String = "",
        @SerializedName("userdef1") var userdef1: String = "",
        @SerializedName("userdef2") var userdef2: String = "",
        @SerializedName("userdef3") var userdef3: String = "",
        @SerializedName("userdef4") var userdef4: String = "",
        @SerializedName("userdef5") var userdef5: String = "")
