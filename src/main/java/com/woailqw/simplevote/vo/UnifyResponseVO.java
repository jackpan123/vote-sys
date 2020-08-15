package com.woailqw.simplevote.vo;

import com.woailqw.simplevote.constant.Code;
import com.woailqw.simplevote.utils.RequestUtil;
import com.woailqw.simplevote.utils.ResponseUtil;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;


/**
 * Uniform API Response.
 * 统一API响应结果封装.
 *
 * @author Jack Pan
 * @version 1.00 2020-08-15.
 */
@Data
@Builder
@AllArgsConstructor
public class UnifyResponseVO<T> {

    private Integer code;

    private T message;

    private String request;

    public UnifyResponseVO() {
        this.code = Code.SUCCESS.getCode();
        this.request = RequestUtil.getSimpleRequest();
    }

    public UnifyResponseVO(int code) {
        this.code = code;
        this.request = RequestUtil.getSimpleRequest();
    }

    public UnifyResponseVO(T message) {
        this.code = Code.SUCCESS.getCode();
        this.message = message;
        this.request = RequestUtil.getSimpleRequest();
    }

    public UnifyResponseVO(int code, T message) {
        this.code = code;
        this.message =  message;
        this.request = RequestUtil.getSimpleRequest();
    }

    public UnifyResponseVO(T message, HttpStatus httpStatus) {
        this.code = Code.SUCCESS.getCode();
        this.message = message;
        this.request = RequestUtil.getSimpleRequest();
        ResponseUtil.setCurrentResponseHttpStatus(httpStatus.value());
    }

    public UnifyResponseVO(int code, T message, HttpStatus httpStatus) {
        this.code = code;
        this.message = message;
        this.request = RequestUtil.getSimpleRequest();
        ResponseUtil.setCurrentResponseHttpStatus(httpStatus.value());
    }

}
