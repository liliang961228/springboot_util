package com.wkk.wkkbjsb.business.easyExcel.controller;

import com.alibaba.excel.EasyExcel;
import com.wkk.wkkbjsb.business.easyExcel.converter.StringConverter;
import com.wkk.wkkbjsb.business.easyExcel.entity.ReqCustomerDailyImport;
import com.wkk.wkkbjsb.business.easyExcel.listener.CustomerDailyImportListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.easyExcel.controller
 * @Description : TODO
 * @Create on : 2021/2/4 10:40
 * @email : lgy961228@gamil.com
 **/
@RequestMapping("easyExcel")
@RestController
@Slf4j
public class importCustomerDaily {

    @PostMapping("/import")
    public void importCustomerDaily(@RequestParam MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<ReqCustomerDailyImport> reqCustomerDailyImports = EasyExcel.read(inputStream)
                .head(ReqCustomerDailyImport.class)
                // 设置sheet,默认读取第一个
                .sheet()
                // 设置标题所在行数
                .headRowNumber(2)
                .doReadSync();
    }

    @PostMapping("/import1")
    public void importCustomerDaily1(@RequestParam MultipartFile file) throws IOException {
        InputStream inputStream = file.getInputStream();
        List<ReqCustomerDailyImport> reqCustomerDailyImports = EasyExcel.read(inputStream)
                // 这个转换是成全局的， 所有java为string,excel为string的都会用这个转换器。
                // 如果就想单个字段使用请使用@ExcelProperty 指定converter
                .registerConverter(new StringConverter())
                // 注册监听器，可以在这里校验字段
                .registerReadListener(new CustomerDailyImportListener())
                .head(ReqCustomerDailyImport.class)
                .sheet()
                .headRowNumber(2)
                .doReadSync();
    }


}
