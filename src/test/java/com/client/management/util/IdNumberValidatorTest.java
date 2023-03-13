package com.client.management.util;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class IdNumberValidatorTest {

    @Test
    public void testValidLength() {

        boolean isValid = IdNumberValidator.isSouthAfrican("9301205582086");
        assertThat(isValid).isEqualTo(true);

    }
}
