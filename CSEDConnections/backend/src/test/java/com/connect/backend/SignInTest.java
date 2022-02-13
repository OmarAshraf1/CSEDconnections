package com.connect.backend;

import static org.junit.jupiter.api.Assertions.*;

import com.connect.backend.Controllers.*;

import org.junit.jupiter.api.Test;

public class SignInTest {
    @Test
    void CorrectEmailPassword() {
        SignController controller = new SignController('G');
        assertTrue(controller.signIn("neno@gmail.com", "123456"));
    }

    @Test
    void CorrectEmailWrongPassword() {
        SignController controller = new SignController('G');
        assertFalse(controller.signIn("neno@gmail.com", "12345678"));
    }

    @Test
    void WrongEmailexistsPassword() {
        SignController controller = new SignController('G');
        assertFalse(controller.signIn("nen@gmail.com", "123456"));
    }

    @Test
    void WrongEmailWrongPassword() {
        SignController controller = new SignController('G');
        assertFalse(controller.signIn("ne@gmail.com", "12345678"));
    }
}
