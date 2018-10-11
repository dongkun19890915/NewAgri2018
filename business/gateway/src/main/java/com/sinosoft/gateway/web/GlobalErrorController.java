package com.sinosoft.gateway.web;

import com.sinosoft.framework.constant.GlobalConstant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.*;
import org.springframework.cloud.sleuth.trace.DefaultTracer;
import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Jason on 2017/7/18.
 */
@Controller
public class GlobalErrorController implements ErrorController {

    @Autowired(required = false)
    private DefaultTracer tracer;

    @Value("${error.path:/error}")
    private String errorPath;

    @Override
    public String getErrorPath() {
        return errorPath;
    }

    @ResponseBody
    @RequestMapping(value = "${error.path:/error}")
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request, HttpServletResponse response) {
        final int status = getErrorStatus(request);
        response.resetBuffer();
        Map<String, Object> body = new HashMap<String, Object>();
        body.put("code","9999");
        body.put("message",getErrorMessage(request));
        return ResponseEntity
                .status(status)
                .header(GlobalConstant.CTX_TRANSACTION_ID,tracer!=null?tracer.getCurrentSpan().traceIdString():"99999999")
                .body(body);
    }

    private int getErrorStatus(HttpServletRequest request) {
        Integer statusCode = (Integer)request.getAttribute("javax.servlet.error.status_code");
        return statusCode != null ? statusCode : HttpStatus.INTERNAL_SERVER_ERROR.value();
    }

    //TODO: 系统内的exception信息不传给前端
    private String getErrorMessage(HttpServletRequest request) {
        final Throwable exc = (Throwable) request.getAttribute("javax.servlet.error.exception");
        return exc != null ? exc.getMessage() : "网关处理异常";
    }
}
