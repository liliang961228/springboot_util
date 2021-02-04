package com.wkk.wkkbjsb.business.easyExcel.export;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.write.style.column.LongestMatchColumnWidthStyleStrategy;
import com.google.common.collect.Lists;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URLEncoder;
import java.util.List;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.easyExcel.export
 * @Description : TODO
 * @Create on : 2021/2/4 11:21
 * @email : lgy961228@gamil.com
 **/

@RequestMapping("exprot")
@RestController
public class RespCustomerDailyExportController {

    @GetMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        // 生成数据
        List<RespCustomerDailyExport> respCustomerDailyImports = Lists.newArrayList();
        for (int i = 0; i < 50; i++) {
            RespCustomerDailyExport respCustomerDailyImport = RespCustomerDailyExport.builder()
                    .misCode(String.valueOf(i))
                    .customerName("customerName" + i)
                    .monthlyQuota(new BigDecimal(String.valueOf(i)))
                    .accountReceivableQuota(new BigDecimal(String.valueOf(i)))
                    .dailyInterestRate(new BigDecimal(String.valueOf(i))).build();
            respCustomerDailyImports.add(respCustomerDailyImport);
        }

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
        String fileName = URLEncoder.encode("导出", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), RespCustomerDailyExport.class)
                .sheet("sheet0")
                // 设置字段宽度为自动调整，不太精确
                .registerWriteHandler(new LongestMatchColumnWidthStyleStrategy())
                .doWrite(respCustomerDailyImports);
    }

}
