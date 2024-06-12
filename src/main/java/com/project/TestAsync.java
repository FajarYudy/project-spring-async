package com.project;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

/**
 * @author fajaryudi
 * @created 2024/06/12 - 09.58
 */
@Slf4j
@Component
public class TestAsync {
    @Async
    @SneakyThrows
    public Future<String> helloNameAsync(final String name) {
        CompletableFuture<String> future = new CompletableFuture<>();
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        future.complete("Hello " + name + " from Thread " + Thread.currentThread());
        return future;
    }

    @Async
    @SneakyThrows
    public void helloAsync() {
        Thread.sleep(Duration.ofSeconds(2).toMillis());
        log.info("hello after 2 seconds {}", Thread.currentThread());
    }
}
