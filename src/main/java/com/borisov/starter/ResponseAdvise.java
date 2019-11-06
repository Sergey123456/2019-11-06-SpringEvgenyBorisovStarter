package com.borisov.starter;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@ControllerAdvice
class ResponseAdvise implements ResponseBodyAdvice<Object> {

    Map<String, Object> responeMap;

    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        return returnType.getExecutable().getDeclaringClass().isAnnotationPresent(MyWrapperForController.class);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        responeMap = Map.of(  "Field1: ", "Field for frontend",
                "Field2", "Field for frontend",
                "response", body);
        return responeMap;
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public Object handleControllerException(HttpServletRequest request, Throwable ex) {
        return Map.of(  "Field1: ", "Field for frontend",
                "Field2", "Field for frontend",
                "response", responeMap.get("response"));
    }
}
