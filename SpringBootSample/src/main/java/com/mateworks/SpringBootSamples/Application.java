package com.mateworks.SpringBootSamples;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.endpoint.SystemPublicMetrics;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
/**
 *
 * Created by James Cheung on 2017/6/30.
 */
@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException {
        //SpringApplication.run(Application.class, args);
        Thread thr = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                try {
                    Thread.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thr.start();
        thr.join();
        System.out.println("Jone Done");
        //thr.sleep(10000);
        System.out.println("DOne");
    }

}
