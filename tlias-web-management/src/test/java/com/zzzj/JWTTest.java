package com.zzzj;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWTTest {
    @Test
    public void genJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "zzj");

        String jwt = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, "enpq")//指定加密算法，签名密钥
                .addClaims(claims)//添加自定义信息
                .setExpiration(new Date(System.currentTimeMillis() + 60 * 1000)) //设置过期时间
                .compact();//生成令牌
        System.out.println(jwt);
        //输出结果：eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAsInVzZXJuYW1lIjoienpqIiwiZXhwIjoxNzYxMzAxMDcyfQ.iHHHK9NOEyAnseHguASzAJRhwz1uy8IGm4EW99HgQ0c
    }

    @Test
    public void parseJwt(){
        Claims claims = Jwts.parser()
                .setSigningKey("enpq")//指定签名密钥
                .parseClaimsJws("eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAsInVzZXJuYW1lIjoienpqIiwiZXhwIjoxNzYxMzAzNDMwfQ.zynunUY6-lZZZXG9nuCPiGLYXh4iBnLCO5mldA2eqfw")//解析令牌
                .getBody();//获取自定义信息

        System.out.println(claims);
    }
}
