package com.wkk.wkkbjsb.business.httpClient;

import lombok.extern.slf4j.Slf4j;

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