package com.woailqw.simplevote.utils;

import com.woailqw.simplevote.constant.Code;
import com.woailqw.simplevote.vo.PageResponseVO;
import com.woailqw.simplevote.vo.UnifyResponseVO;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * Util for create response.
 * 响应结果生成工具
 *
 * @author Jack Pan.
 * @version 1.00 2020-08-15
 */
@SuppressWarnings("unchecked")
@Slf4j
public class ResponseUtil {

    /**
     * 获得当前响应
     *
     * @return 响应
     */
    public static HttpServletResponse getResponse() {
        return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
    }

    public static void setCurrentResponseHttpStatus(int httpStatus) {
        getResponse().setStatus(httpStatus);
    }

    public static <T> UnifyResponseVO<T> generateCreatedResponse(int code) {
        return (UnifyResponseVO<T>) UnifyResponseVO.builder()
                .message(Code.CREATED.getDescription())
                .code(code)
                .request(RequestUtil.getSimpleRequest())
                .build();
    }

    public static <T> UnifyResponseVO<T> generateCreatedResponse(int code, T data) {
        return (UnifyResponseVO<T>) UnifyResponseVO.builder()
                .message(data)
                .code(code)
                .request(RequestUtil.getSimpleRequest())
                .build();
    }

    public static <T> UnifyResponseVO<T> generateDeletedResponse(int code) {
        return (UnifyResponseVO<T>) UnifyResponseVO.builder()
                .message(Code.SUCCESS.getDescription())
                .code(code)
                .request(RequestUtil.getSimpleRequest())
                .build();
    }

    public static <T> UnifyResponseVO<T> generateDeletedResponse(int code, T data) {
        return (UnifyResponseVO<T>) UnifyResponseVO.builder()
                .message(data)
                .code(code)
                .request(RequestUtil.getSimpleRequest())
                .build();
    }

    public static <T> UnifyResponseVO<T> generateUpdatedResponse(int code) {
        return (UnifyResponseVO<T>) UnifyResponseVO.builder()
                .message(Code.SUCCESS.getDescription())
                .code(code)
                .request(RequestUtil.getSimpleRequest())
                .build();
    }

    public static <T> UnifyResponseVO<T> generateUpdatedResponse(int code, T data) {
        return (UnifyResponseVO<T>) UnifyResponseVO.builder()
                .message(data)
                .code(code)
                .request(RequestUtil.getSimpleRequest())
                .build();
    }

    public static <T> UnifyResponseVO<T> generateUnifyResponse(int code) {
        return (UnifyResponseVO<T>) UnifyResponseVO.builder()
                .code(code)
                .request(RequestUtil.getSimpleRequest())
                .build();
    }

    public static <T> PageResponseVO<T> generatePageResult(int total, List<T> items, int page, int count) {
        return new PageResponseVO<T>(total, items, page, count);
    }
}
