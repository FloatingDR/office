package com.easy.office.config.jwt;


import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @author taylor
 * @ClassName: JWTUtil
 * @Description:
 * @date: 2019-04-27 08:10
 */
public class JWTUtil {

    /**
     * 24h后过期
     */
    private static final long EXPIRE_TIME = 60 * 24 * 60 * 1000;

    /**
     * 校验token是否正确
     * @param token 密钥
     * @param username 用户名
     * @param password 用户的密码
     * @return 是否正确
     */
    public static boolean verify(String token, String username, String password){
        try{
            Algorithm algorithm=Algorithm.HMAC256(password);
            JWTVerifier verifier= JWT.require(algorithm)
                    .withClaim("username",username)
                    .build();
            /**
             * verifier.verify返回一个JWT.decode(token)
             * 如果在校验过程中没有匹配到，将抛出一个JWTVerificationException异常
             * @return JWT.decode(token)
             */
            DecodedJWT jwt=verifier.verify(token);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /**
     * 获取token中包含的用户名
     * @param token
     * @return username
     */
    public static String getUsername(String token){
        try{
            DecodedJWT jwt=JWT.decode(token);
            return jwt.getClaim("username").asString();
        }catch (JWTDecodeException e){
            return null;
        }
    }

    /**
     * 生成签名，过期时间为 EXPIRE_TIME
     * @param username 用户名
     * @param password 用户的密码
     * @return 加密的token
     */
    public static String sign(String username,String password){
        try {
            Date date=new Date(System.currentTimeMillis()+EXPIRE_TIME);
            Algorithm algorithm=Algorithm.HMAC256(password);
            return JWT.create()
                    .withClaim("username",username)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (UnsupportedEncodingException e){
            return null;
        }
    }
}
