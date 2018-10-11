package com.sinosoft.admin.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Jason on 2017/6/14.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseDto jsonErrorHandler(HttpServletRequest req, Exception e){
        ResponseDto resp = new ResponseDto();
        resp.setCode("9999");
        resp.setMessage(e.getMessage());
        return resp;
    }

    public class ResponseDto {
        String code;
        String message;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
