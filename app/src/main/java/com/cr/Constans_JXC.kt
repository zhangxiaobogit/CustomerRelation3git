package com.cr

class Constans_JXC {
    companion object {
        const val TABLE_NAME_CGSH: String = "tb_received"

        const val CURRENT_ACTIVITY_NAME: String = "CURRENT_ACTIVITY_NAME"// 当前action操作

        const val CGDD_ADD_ACTION: String = "CGDD_ADD_ACTION"// 采购订单新增
        const val CGDD_CHECK_ACTION: String = "CGDD_CHECK_ACTION"// 采购订单查看


        const val XSKD_ADD_ACTION: String = "XSKD_ADD_ACTION"// 销售开单新增
        const val XSKD_CHECK_ACTION: String = "XSKD_CHECK_ACTION"// 销售开单查看

        const val BILL_MASTER_CHECK_CODE: Int = 1001// 单查看单据code
        const val BILL_DETAIL_CHECK_CODE: Int = 1002// 单查看单据code
        const val BILL_DELETE_CODE: Int = 1003// 删除单据code
        const val BILL_ADUIT_CODE: Int = 1004// 审核单据code

    }

}