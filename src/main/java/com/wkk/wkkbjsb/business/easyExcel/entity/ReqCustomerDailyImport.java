package com.wkk.wkkbjsb.business.easyExcel.entity;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.elasticjob
 * @Description : TODO
 * @Create on : 2021/2/4 10:36
 * @email : lgy961228@gamil.com
 **/

@Data
public class ReqCustomerDailyImport {

    /**
     * 客户名称
     */
    @ExcelProperty(index = 0)
    private String customerName;

    /**
     * MIS编码
     */
    @ExcelProperty(index = 1)
    private String misCode;

    /**
     * 月度滚动额
     */
    @ExcelProperty(index = 3)
    private BigDecimal monthlyQuota;

    /**
     * 最新应收账款余额
     */
    @ExcelProperty(index = 4)
    private BigDecimal accountReceivableQuota;

    /**
     * 本月利率(年化）
     */
    @ExcelProperty(index = 5)
    private BigDecimal dailyInterestRate;
}
