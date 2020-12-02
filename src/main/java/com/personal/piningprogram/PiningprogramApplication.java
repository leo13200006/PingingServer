package com.personal.piningprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;

@SpringBootApplication
public class PiningprogramApplication {
    public static void main(String[] args) throws InterruptedException, IOException {
        SpringApplication.run(PiningprogramApplication.class, args);
        while(true) {
            URL siteURL = new URL("https://fasim.herokuapp.com/");
            HttpURLConnection connection = (HttpURLConnection) siteURL.openConnection();
            connection.setRequestMethod("GET");
            connection.setConnectTimeout(3000);
            connection.connect();

            int code = connection.getResponseCode();
            if (code == 200) {
                GetClass.incCount();
                System.out.println("Ping");
            } else {
                System.out.println("Can't Ping");
            }

            Thread.sleep(2000);
        }
    }

}
