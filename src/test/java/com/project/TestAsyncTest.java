package com.project;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author fajaryudi
 * @created 2024/06/12 - 10.01
 */
@Slf4j
@SpringBootTest
class TestAsyncTest {
    @Autowired
    TestAsync testAsync;

    @Test
    void helloAsyncTest() throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            testAsync.helloAsync();
        }
        log.info("after call helloAsync()");
        Thread.sleep(Duration.ofSeconds(10).toMillis());
    }

    @Test
    void helloNameAsyncTest() throws ExecutionException, InterruptedException {
        Future<String> future = testAsync.helloNameAsync("Budi");
        log.info("after call helloNameAsync");
        String response = future.get();
        log.info(response);
    }

}