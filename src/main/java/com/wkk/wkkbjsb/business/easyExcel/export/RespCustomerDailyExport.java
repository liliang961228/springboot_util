package com.wkk.wkkbjsb.business.easyExcel.export;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.NumberFormat;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.easyExcel.export
 * @Description : TODO
 * @Create on : 2021/2/4 11:20
 * @email : lgy961228@gamil.com
 **/

@Data
@Builder
public class RespCustomerDailyExport {

    @ExcelProperty("客户编码")
    private String customerName;

    @ExcelProperty("MIS编码")
    private String misCode;

    @ExcelProperty("月度滚动额")
    private BigDecimal monthlyQuota;

    @ExcelProperty("最新应收账款余额")
    private BigDecimal accountReceivableQuota;

    @NumberFormat("#.##%")
    @ExcelProperty("本月利率(年化）")
    private BigDecimal dailyInterestRate;
}
