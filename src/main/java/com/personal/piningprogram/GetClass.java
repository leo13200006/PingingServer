package com.personal.piningprogram;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;

@RestController
public class GetClass {
    public static BigInteger countOfPing = BigInteger.ZERO;

    public static void incCount() {
        countOfPing = countOfPing.add(BigInteger.ONE);
    }

    public static String getCount() {
        return countOfPing.toString();
    }

    @GetMapping("/")
    public String helloWorld() {
        return "Hello World This is Pinging Server";
    }

    @GetMapping("/ping")
    public String ping() {
        return "Ping Count - " + GetClass.getCount();
    }

}
