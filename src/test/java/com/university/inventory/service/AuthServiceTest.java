package com.university.inventory.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

@ExtendWith(MockitoExtension.class)
public class AuthServiceTest {

    @Mock
    private AuthService SUT;

    @BeforeAll
    static void beforeAll() {

    }
}
