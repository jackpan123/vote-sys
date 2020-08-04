package com.woailqw.simplevote;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@Api(value = "Test")
public class SimpleVoteApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleVoteApplication.class, args);
    }

    @ApiOperation(value = "testOperation")
    @GetMapping("hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }


}
