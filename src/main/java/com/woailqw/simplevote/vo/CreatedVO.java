package com.woailqw.simplevote.vo;

import com.woailqw.simplevote.constant.Code;
import com.woailqw.simplevote.utils.ResponseUtil;
import org.springframework.http.HttpStatus;

/**
 * Create VO.
 *
 * @author Jack Pan
 */
public class CreatedVO extends UnifyResponseVO<String> {

    public CreatedVO() {
        super(Code.CREATED.getCode());
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public CreatedVO(int code) {
        super(code);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public CreatedVO(String message) {
        super(message);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    public CreatedVO(int code, String message) {
        super(code, message);
        ResponseUtil.setCurrentResponseHttpStatus(HttpStatus.CREATED.value());
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
