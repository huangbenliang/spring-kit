package org.firsttime.springkit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringKitApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringKitApplication.class, args);
    }


    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
