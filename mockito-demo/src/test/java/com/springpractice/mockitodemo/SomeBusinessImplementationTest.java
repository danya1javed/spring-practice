package com.springpractice.mockitodemo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class SomeBusinessImplementationTest {

  @Test
  @DisplayName("Find the Greatest Number From All The Data Using Stub")
  void findTheGreatestFromAllDataUsingStub() {
    SomeBusinessImplementation someBusinessImplementation = new SomeBusinessImplementation(
            new DataServiceStub()
    );
    Assertions.assertTrue(someBusinessImplementation.findTheGreatestFromAllData() == 5);
  }

//  Temp Class created Just for the testing
  class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData(){
      return new int[]{ 1, 2, 4, 5};
    }
  }

  @Test
  @DisplayName("Find the Greatest Number From All The Data Using Mock")
  void findTheGreatestFromAllDataUsingMock() {
    DataService dataServiceMock = mock(DataService.class);
    when(dataServiceMock.retrieveAllData()).thenReturn(new int[]{ 1, 20, 49});
    SomeBusinessImplementation someBusinessImplementation = new SomeBusinessImplementation(
            dataServiceMock
    );
    Assertions.assertTrue(someBusinessImplementation.findTheGreatestFromAllData() == 49);
  }


}