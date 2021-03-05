package com.springpractice.mockitodemo;

import java.util.Arrays;

public class SomeBusinessImplementation {
  private DataService dataService;

  public SomeBusinessImplementation(DataService dataService) {
    super();
    this.dataService = dataService;
  }

  int findTheGreatestFromAllData() {
    return Arrays.stream(dataService.retrieveAllData()).max().orElse(0);
  }
}