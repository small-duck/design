package com.zy.jwt.rest;

import com.zy.jwt.utils.JwtUtils;
import io.jsonwebtoken.Claims;
import org.joda.time.DateTime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName UserResource
 * @Description 用户相关
 * @Author Benny
 * @Date 2018/10/7 0007 16:01
 * @Version 1.0
 **/
@RestController
@RequestMapping("/v1/user")
public class UserResource {


    @RequestMapping("/login")
    public ResponseEntity login(){
        Map<String, Object> map = new HashMap<>();
        map.put("exp",DateTime.now().plusSeconds(10).toDate().getTime()/1000);
        map.put("uid", "123456");
        String token = JwtUtils.createToken("123456",new Date(System.currentTimeMillis()+60000));
        return new ResponseEntity(token, HttpStatus.OK);
    }

    @RequestMapping("/find/{token}")
    public ResponseEntity findUser(@PathVariable String token) {

        Claims claims = JwtUtils.phaseToken(token);
        String  uid = (String) claims.get("session");
        return new ResponseEntity(uid,HttpStatus.OK);
    }
}

