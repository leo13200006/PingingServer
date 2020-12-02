package com.personal.piningprogram;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class GetClass {
    public static BigInteger countOfPing = new BigInteger(String.valueOf(0));

    public static void incCount() {
        countOfPing.add(new BigInteger(String.valueOf(1)));
    }

    public static String getCount() {
        return countOfPing.toString();
    }

    @GetMapping("/")
    public String helloWolrd() {
        return "Hello Wolrd \n" +
                "Ping count - " + GetClass.getCount();
    }

}
