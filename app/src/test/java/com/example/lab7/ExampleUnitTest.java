package com.example.lab7;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ExampleUnitTest {

    private ValidateName nameValidator;

    @Before
    public void setUp() {
        nameValidator = new ValidateName();
    }

    @Test
    public void testNameLengthLessThan10() {
        assertTrue(nameValidator.isNameLengthValid("marc"));
    }

    @Test
    public void testNameLengthGreaterThan10() {
        assertFalse(nameValidator.isNameLengthValid("this_name_is_too_long"));
    }

}