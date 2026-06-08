package com.vsbt.vsbtbackend;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


public class testEnv {

    @Test
    public void testEnv() {
        System.out.println(
                System.getenv("OSS_ACCESS_KEY_ID")
        );
    }
}
