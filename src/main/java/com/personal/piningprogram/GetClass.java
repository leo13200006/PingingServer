package com.personal.piningprogram;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GetClass {
    public static int countOfPing = 0;

    public static void incCount() {
        countOfPing ++;
    }

    public static int getCount() {
        return  countOfPing;
    }

    @GetMapping("/")
    public String helloWolrd() {
        return "Hello Wolrd \n" +
                "Ping count - " + GetClass.getCount();
    }

}
