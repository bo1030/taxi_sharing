package com.taxisharing.server;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCrypt;

@SpringBootTest
class ServerApplicationTests {

    @Test
    void contextLoads() {
        String temp = BCrypt.hashpw("abcd",BCrypt.gensalt());
        System.out.println(temp.length());
        System.out.println(BCrypt.checkpw("abcd",temp));
    }

}
