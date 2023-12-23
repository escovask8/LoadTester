package com.example.demo;


import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoadTestController {

    @Autowired
    private LoadTestService loadTestService;

    @GetMapping("/loadtest")
    public ResponseEntity<String> performLoadTest(
            @RequestParam(value = "url") String url,
            @RequestParam(value = "requests", defaultValue = "10") int requests,
            @RequestParam(value = "concurrent", defaultValue = "1") int concurrent,
            @RequestParam(value = "file", required = false) String file) throws IOException {

        List<String> urls = loadTestService.getUrlsFromFile(file, url);
		LoadTestResult result = loadTestService.runLoadTest(urls, requests, concurrent);
		return ResponseEntity.ok(result.toString());
    }
}
