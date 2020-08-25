package com.cr.activity.jxc

import java.util.*

class JXC_HTTP_Util private constructor() {
    companion object {
        var instance: JXC_HTTP_Util? = null
            get() {
                if (field == null) {
                    field = JXC_HTTP_Util()
                }
                return field
            }


    }
    @Synchronized
    fun get(): JXC_HTTP_Util{
        return instance!!
    }
    fun deleteData(dbName: String, tabname: String, pkvalue: String, opid: String): Map<*, *> {
//        parmMap.put("dbname", ShareUserInfo.getDbName(mContext));
//        parmMap.put("opid", ShareUserInfo.getUserId(mContext));
//        parmMap.put("tabname", "tb_received");
//        parmMap.put("pkvalue", this.getIntent().getExtras().getString("billid"));
//
        val parmMap: MutableMap<String, Any> = HashMap()
        parmMap["dbname"] = dbName
        parmMap["tabname"] = tabname
        parmMap["pkvalue"] = pkvalue
        parmMap["opid"] = opid
        return parmMap!!
    }
    fun getMasterBillData(dbName: String, parms: String, billid: String, opid: String): Map<*, *> {
//      Map<String, Object> parmMap = new HashMap<String, Object>();
//        parmMap.put("dbname", ShareUserInfo.getDbName(mContext));
//        parmMap.put("parms", "CGSH");
//        parmMap.put("billid", this.getIntent().getExtras().getString("billid"));
//        parmMap.put("opid", ShareUserInfo.getUserId(mContext));
//
        val parmMap: MutableMap<String, Any> = HashMap()
        parmMap["dbname"] = dbName
        parmMap["parms"] = parms
        parmMap["billid"] = billid
        parmMap["opid"] = opid
        return parmMap!!
    }


    fun getBillDetailData(dbName: String, parms: String, billid: String): Map<*, *> {
//      Map<String, Object> parmMap = new HashMap<String, Object>();
//        parmMap.put("dbname", ShareUserInfo.getDbName(mContext));
//        parmMap.put("parms", "CGSH");
//        parmMap.put("billid", this.getIntent().getExtras().getString("billid"));
//        parmMap.put("opid", ShareUserInfo.getUserId(mContext));
//
        val parmMap: MutableMap<String, Any> = HashMap()
        parmMap["dbname"] = dbName
        parmMap["parms"] = parms
        parmMap["billid"] = billid
        return parmMap!!
    }


    fun saveBillData(dbName: String, tabname:String, parms: String, master: String, detail: String): Map<*, *> {
//      Map<String, Object> parmMap = new HashMap<String, Object>();
//        parmMap.put("dbname", ShareUserInfo.getDbName(mContext));
//        parmMap.put("parms", "CGSH");
//        parmMap.put("billid", this.getIntent().getExtras().getString("billid"));
//        parmMap.put("opid", ShareUserInfo.getUserId(mContext));
//
        val parmMap: MutableMap<String, Any> = HashMap()
        parmMap["dbname"] = dbName
        parmMap["tabname"] = tabname
        parmMap["parms"] = parms
        parmMap["master"] = master
        parmMap["detail"] = detail
        return parmMap!!
    }
}