package com.easy.office.config.shiro;

import com.easy.office.config.jwt.JWTToken;
import com.easy.office.config.jwt.JWTUtil;
import com.easy.office.mapper.UserMapper;
import com.easy.office.model.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author taylor
 * @ClassName: UserRealm
 * @Description: 自定义Realm，用于处理用户是否合法
 * @date: 2019-04-24 19:20
 */
@Service
@Slf4j
public class UserRealm extends AuthorizingRealm {

    @Resource
    private UserMapper userMapper;

    /**
     * 必须重写此方法，不然shiro会报错
     * @param token
     * @return
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    /**
     * 执行授权逻辑
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        return null;
    }

    /**
     * 执行认证逻辑
     * @param authToken
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
        String token=(String)authToken.getCredentials();
        //解密获得username,用于和数据库对比
        String username= JWTUtil.getUsername(token);

        if(username==null){
            throw new AuthenticationException("token invalid");
        }
        User user=userMapper.getInfoByUsername(username);

        if(user==null){
            throw new AuthenticationException("user not found");
        }

        if (!JWTUtil.verify(token, username, user.getPassword())) {
            throw new AuthenticationException("username or password error");
        }
        return new SimpleAuthenticationInfo(token, token,"UserRealm");
    }
}
