package com.tec.anji.component;

import com.tec.anji.exception.UserNotExistException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class MyExceptionHandler {

//    @ResponseBody
//    @ExceptionHandler(UserNotExistException.class)
//    public Map<String, Object> handleException(Exception ex) {
//        Map<String, Object> map = new HashMap<>(2);
//        map.put("code", "user.not.exist");
//        map.put("message", ex.getMessage());
//        return map;
//    }

    @ExceptionHandler(UserNotExistException.class)
    public String handleException(Exception ex, HttpServletRequest request) {
        Map<String, Object> ext = new HashMap<>(2);
        ext.put("code", "user.not.exist");
        ext.put("message", ex.getMessage());
        request.setAttribute("ext", ext);
        return "forward:/error";
    }
}
