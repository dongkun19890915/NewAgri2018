package com.sinosoft.fileserver.controller;

import com.alibaba.dubbo.rpc.RpcException;
import com.sinosoft.framework.dto.ResponseDto;
import com.sinosoft.framework.exception.BaseException;
import com.sinosoft.framework.exception.BusinessException;
import com.sinosoft.framework.exception.SystemException;
import com.sinosoft.framework.exceptionlog.UserException;
import com.sinosoft.framework.web.controller.JsonExceptionResolver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FileServerJsonExceptionResolver extends JsonExceptionResolver {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileServerJsonExceptionResolver.class);
    private String resultCode = "error";
    private String resultMsg = "系统异常,请联系系统管理员!";

    @Override
    protected ModelAndView doResolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        {
            String url = "";
            if (request != null && !(request.getRequestURI().isEmpty())) {
                url = request.getRequestURL().toString();
            }
            ResponseDto responseDto = new ResponseDto();
            responseDto.setTransactionID("00000000000000000");
            if (SystemException.class.isInstance(ex)) {
                SystemException sexp = (SystemException) ex;
                String detail = sexp.getMessage();
                String code = sexp.getCode();
                responseDto.setResultCode(code);
                responseDto.setResultMsg(detail);
            } else if (!BusinessException.class.isInstance(ex)) {
                if (BaseException.class.isInstance(ex)) {
                    BaseException baseException = (BaseException) ex;

                    try {
                        UserException ue = UserException.newException(baseException.getCode(), (String) null);
                        if (ue != null) {
//                            baseException.setMessage(ue.getErrorMessage());
                        }
                    } catch (Exception var9) {
                        LOGGER.error("转换EXCEPTION异常 "+url, var9);
                    }

                    responseDto.setResultCode(baseException.getCode());
                    responseDto.setResultMsg(baseException.getMessage());
                    LOGGER.error("业务异常 "+url, ex);
                } else if (UserException.class.isInstance(ex)) {
                    UserException userException = (UserException) ex;
                    responseDto.setResultCode(String.valueOf(userException.getErrorNo()));
                    responseDto.setResultMsg(userException.getErrorMessage());
                    LOGGER.error("自定义异常 "+url, ex);
                } else if (RpcException.class.isInstance(ex)) {
                    responseDto.setResultCode("9999");
                    responseDto.setResultMsg("远程服务不可用");
                    LOGGER.error("远程服务调用异常 "+url, ex);
                } else {
                    responseDto.setResultCode(this.resultCode);
                    responseDto.setResultMsg(this.resultMsg);
                    LOGGER.error("未知异常 "+url, ex);
                }
            }

            return (new ModelAndView(new JsonExceptionResolver.JsonView())).addObject("responseDto", responseDto);
        }
    }
}
