package com.personal.piningprogram;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.InetAddress;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.ArrayList;

@SpringBootApplication
public class PiningprogramApplication {
    public static void main(String[] args) throws InterruptedException, IOException {
        SpringApplication.run(PiningprogramApplication.class, args);
        ArrayList<URL> siteURLs = new ArrayList<>();
        siteURLs.add(new URL("https://fasim.herokuapp.com/"));
        siteURLs.add(new URL("https://mesmovies.herokuapp.com/"));

        while(true) {
            for(URL siteURL : siteURLs) {
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

}
