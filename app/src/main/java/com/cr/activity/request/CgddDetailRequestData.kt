package com.cr.activity.request

import com.cr.activity.jxc.KtXzspData
import com.cr.activity.response.CgddDetailResponseData
import com.cr.activity.response.XsddDetailResponseData
import com.google.gson.annotations.SerializedName

data class CgddDetailRequestData(
        /**
         * 0或空表示新增
         */
        @SerializedName("billid") var billid: String = "0",
        @SerializedName("itemno") var itemno: String = "0",
        @SerializedName("goodsid") var goodsid: String = "",
        @SerializedName("unitid") var unitid: String = "",
        @SerializedName("unitprice") var unitprice: String = "",
        @SerializedName("unitqty") var unitqty: String = "",
        @SerializedName("disc") var disc: String = "100",
        @SerializedName("amount") var amount: String = "",
        @SerializedName("batchcode") var batchcode: String = "",
        @SerializedName("produceddate") var produceddate: String = "",
        @SerializedName("validdate") var validdate: String = "",
        @SerializedName("batchrefid") var batchrefid: String = "",
        @SerializedName("refertype") var refertype: String = "",
        @SerializedName("referbillid") var referbillid: String = "",
        @SerializedName("referitemno") var referitemno: String = "",
        @SerializedName("taxrate") var taxrate: String = "",
        @SerializedName("taxunitprice ") var taxunitprice: String = "",
        @SerializedName("memo") var memo: String = "",
        @SerializedName("userdef1")
        var userdef1: String = "",
        @SerializedName("userdef2")
        var userdef2: String = "",
        @SerializedName("userdef3")
        var userdef3: String = "",
        @SerializedName("userdef4")
        var userdef4: String = "",
        @SerializedName("userdef5")
        var userdef5: String = ""
) {

    constructor(detailResponseData: CgddDetailResponseData) : this() {
        goodsid = detailResponseData.goodsid
        unitid = detailResponseData.unitid
        unitprice = detailResponseData.unitprice
        unitqty = detailResponseData.unitqty
        amount = detailResponseData.amount
        batchcode = detailResponseData.batchcode
        produceddate = detailResponseData.produceddate
        validdate = detailResponseData.validdate
        batchrefid = detailResponseData.batchrefid
        taxrate = detailResponseData.taxrate
        taxunitprice = detailResponseData.taxunitprice
        memo = detailResponseData.memo
        userdef1 = detailResponseData.userdef1
        userdef2 = detailResponseData.userdef2
        userdef3 = detailResponseData.userdef3
        userdef4 = detailResponseData.userdef4
        userdef5 = detailResponseData.userdef5

    }


}
