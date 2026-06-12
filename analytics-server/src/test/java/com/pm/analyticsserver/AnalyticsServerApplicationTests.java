package com.pm.analyticsserver;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(properties = "spring.kafka.listener.auto-startup=false")
class AnalyticsServerApplicationTests {

    @Test
    void contextLoads() {
    }

}
