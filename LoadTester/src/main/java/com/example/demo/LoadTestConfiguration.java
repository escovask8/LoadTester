package com.example.demo;
import org.springframework.beans.factory.annotation.Value;

public class LoadTestConfiguration {


    @Value("${loadtest.default-requests:10}")
    private int defaultRequests;

    public int getDefaultRequests() {
        return defaultRequests;
    }
}
