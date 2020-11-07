package com.agileengine.test.service.impl;

import com.agileengine.testtask.Application;
import com.agileengine.testtask.service.AuthService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(classes = Application.class)
class AuthServiceImplTest {
    @Autowired
    private AuthService authService;

    @Test
    void getToken() {
        assertNotNull(authService.getToken());
    }
}