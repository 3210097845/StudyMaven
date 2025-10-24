package com.zzzj.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static String signKey = "SVRIRUlNQQ==";//密钥
    private static Long expire = 43200000L;//令牌有效期，单位毫秒，这里设置12小时

    /**
     * 生成JWT令牌
     * @return
     */
    public static String generateJwt(Map<String,Object> claims){
        String jwt = Jwts.builder()//创建JWT的创建者
                .addClaims(claims)//添加自定义信息
                .signWith(SignatureAlgorithm.HS256, signKey)//签名算法和密钥
                .setExpiration(new Date(System.currentTimeMillis() + expire))//设置令牌有效期
                .compact();//生成令牌
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        Claims claims = Jwts.parser()
                .setSigningKey(signKey)
                .parseClaimsJws(jwt)
                .getBody();
        return claims;
    }
}
