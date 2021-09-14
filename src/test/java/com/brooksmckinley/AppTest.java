/*
 *  UCF COP3330 Fall 2021 Assignment 1 Solution
 *  Copyright 2021 Brooks McKinley
 */

package com.brooksmckinley;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class AppTest {

    @Test
    public void testBACReport() {
        String expected = "Your BAC is 0.049323\n" +
                "It is legal for you to drive.";
        String actual = App.getAlcoholReport(1, 3, 175, 1);
        Assertions.assertEquals(expected, actual);
    }
}