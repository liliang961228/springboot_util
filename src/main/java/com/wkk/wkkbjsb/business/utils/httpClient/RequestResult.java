package com.wkk.wkkbjsb.business.utils.httpClient;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.http.client.methods.*;
import org.apache.http.conn.ssl.TrustStrategy;

import org.apache.http.ssl.SSLContexts;

import javax.net.ssl.SSLContext;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author : ligengying
 * @Package : com.wkk.wkkbjsb.business.utils.httpClient
 * @Description : 上传返回结果封装
 * @Create on : 2021/1/27 19:26
 * @email : lgy961228@gamil.com
 **/

@Slf4j
public class RequestResult {

    private boolean isSuccess;//是否成功
    private String msg;//消息

    public boolean isSuccess() {
        return isSuccess;
    }

    public RequestResult setSuccess(boolean success) {
        isSuccess = success;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public RequestResult setMsg(String msg) {
        this.msg = msg;
        return this;
    }

    public RequestResult() {
        this.isSuccess = false;
    }
}