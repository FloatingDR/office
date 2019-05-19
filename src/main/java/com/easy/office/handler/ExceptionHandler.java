package com.easy.office.handler;

import com.easy.office.bean.ResponseBean;
import com.easy.office.bean.ResultCode;
import org.apache.shiro.authc.ExpiredCredentialsException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authz.AuthorizationException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author taylor
 * @ClassName: ExceptionHandler
 * @Description: 自定义springboot异常
 * @date: 2019-05-19 00:33
 */
@RestControllerAdvice
public class ExceptionHandler {

    /**
     * token 无效
     * @return
     */
    @org.springframework.web.bind.annotation.ExceptionHandler(ExpiredCredentialsException.class)
    public ResponseBean tokenInvalid(){
        return new ResponseBean(ResultCode.FORBIDDEN,"token invalid","token 无效");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(UnknownAccountException.class)
    public ResponseBean unKnowAccount(){
        return new ResponseBean(ResultCode.FORBIDDEN,"user not found","没有该用户");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(IncorrectCredentialsException.class)
    public ResponseBean usernameOrPasswordError(){
        return new ResponseBean(ResultCode.FORBIDDEN,"username or password error","用户名或密码错误");
    }

    @org.springframework.web.bind.annotation.ExceptionHandler(AuthorizationException.class)
    public ResponseBean permissionDeniedError(){
        return new ResponseBean(ResultCode.FORBIDDEN,"ERROR Permission denied","权限不足");
    }

    /**
     * 捕捉其他所有异常
     */
//    @org.springframework.web.bind.annotation.ExceptionHandler(Exception.class)
//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    public ResponseBean globalException() {
//        return new ResponseBean(ResultCode.FAIL,"fail","服务器内部错误");
//    }

}
