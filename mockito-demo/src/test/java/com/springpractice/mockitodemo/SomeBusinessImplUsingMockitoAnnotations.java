package com.springpractice.mockitodemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assumptions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SomeBusinessImplUsingMockitoAnnotations {

  @Mock
  DataService dataService;

  @InjectMocks
  SomeBusinessImplementation someBusinessImplementation;

  @Test
  @DisplayName("Check the greatest number")
  @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Not for Windows")
  public void TestBusinessImplWith(){
//    Assumptions.assumeTrue("It".equals("External Service Not Working"));
    when(dataService.retrieveAllData()).thenReturn(new int[]{ 1, 10, 50, 100 });
    Assertions.assertTrue(someBusinessImplementation.findTheGreatestFromAllData() == 100);
  }

  @Test
  @DisplayName("Check the greatest number - empty array provided")
  public void TestBusinessImplWith_OneValue(){
    when(dataService.retrieveAllData()).thenReturn(new int[]{10});
    Assertions.assertTrue(someBusinessImplementation.findTheGreatestFromAllData() == 10);
  }

  @Test
  @DisplayName("Check the greatest number - one value provided")
  public void TestBusinessImplWith_NoValue(){
    when(dataService.retrieveAllData()).thenReturn(new int[]{});
    Assertions.assertTrue(someBusinessImplementation.findTheGreatestFromAllData() == 0);
  }
}
