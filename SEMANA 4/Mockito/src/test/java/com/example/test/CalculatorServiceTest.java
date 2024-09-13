package com.example.test;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.service.CalculatorService;

public class CalculatorServiceTest {

    @Mock
    CalculatorService calculatorService; // Mocking the service

    @InjectMocks
    CalculatorServiceTest testSubject; // Inject the mock into the test subject

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAdd() {
        when(calculatorService.add(10, 20)).thenReturn(30);

        assertEquals(30, calculatorService.add(10, 20));
        verify(calculatorService).add(10, 20); // Verifying interaction
    }

    @Test
    public void testMultiply() {
        when(calculatorService.multiply(5, 5)).thenReturn(25);

        assertEquals(25, calculatorService.multiply(5, 5));
        verify(calculatorService).multiply(5, 5); // Verifying interaction
    }
}
