package com.koreait.facebook.common;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.util.Random;
import java.util.UUID;

@Component
public class MySecurityUtils {

    // len 길이 만큼의 랜덤한 숫자
    public String getRandomValue(int len){
        UUID uuid = UUID.randomUUID();
        String randomString = "";
        if(len >= 36){
            for(int i=0; i>len/36; i++){
                randomString += uuid.toString().substring(0,len);
            }
        }else{
            randomString = uuid.toString().substring(0,len);
        }
        return randomString;
    }
    public String getRandomValue1(int len){
        return RandomStringUtils.randomAlphanumeric(len);
    }
}
