package com.zy.jwt.utils;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;
import java.security.Key;
import java.util.Date;
import java.util.Map;

/**
 * @ClassName JwtUtils
 * @Description token工具类
 * @Author Benny
 * @Date 2018/10/7 0007 15:47
 * @Version 1.0
 **/
public class JwtUtils {


    public static String createToken(String uid,Date expDate) {
        ObjectMapper objectMapper = new ObjectMapper();
            JwtBuilder builder =
                    Jwts.builder().setHeaderParam("typ", "JWT").claim("session",uid).signWith(SignatureAlgorithm.HS256, generatorKey());

        builder.setExpiration(expDate).setNotBefore(new Date(System.currentTimeMillis()));
//            return Jwts.builder().setPayload(objectMapper.writeValueAsString(map))
//                    .signWith(SignatureAlgorithm.HS256, generatorKey())
//                    .compact()？;
        return builder.compact();
    }


    private static Key generatorKey(){
        SignatureAlgorithm saa=SignatureAlgorithm.HS256;
        byte[] bin=DatatypeConverter.parseBase64Binary
                ("f3973b64918e4324ad85acea1b6cbec5");
        Key key=new SecretKeySpec(bin,saa.getJcaName());
        return key;
    }

    public static Claims phaseToken(String token) {
        return Jwts.parser().setSigningKey(generatorKey())
                .parseClaimsJws(token).getBody();
    }
}
