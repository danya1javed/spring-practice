package com.programming.techie;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.DisabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

import java.util.Random;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class ContactManagerTest {
  ContactManager contactManager;

  @BeforeAll
  public static void startTest(){
    System.out.println("Starting test...");
  }

  @BeforeEach
  public void createContactManageInstance(){
    System.out.println("Instantiating Contact Manager...");
    contactManager = new ContactManager();
  }

  @Test
  @DisplayName("Check if a new contact is created with correct details.")
  void shouldCreateContact() {
    contactManager.addContact("Tom", "Hardy", "0070070077");
    Assertions.assertFalse(contactManager.contactList.isEmpty());
    Assertions.assertEquals(1, contactManager.contactList.size());
    Assertions.assertTrue(
            contactManager.getAllContacts().stream()
            .anyMatch(contact -> contact.getFirstName().equals("Tom") &&
                    contact.getLastName().equals("Hardy") &&
                    contact.getPhoneNumber().equals("0070070077")
            )
    );
  }

  @Test
  @DisplayName("Should throw a runtime exception if first name is null")
  public void shouldThrowExceptionFirstNameNull(){
    Assertions.assertThrows(RuntimeException.class, () -> {
      contactManager.addContact(null,"Som", "1234567780");
    }); // lambda will return a runtime exception.
  }

  // Conditional Execution - EnableOn, DisabledOn
  @Test
  @DisabledOnOs(value = OS.WINDOWS, disabledReason = "Should not run on windows")
  public void getAllContacts() {
  }

//  Assumptions should not fail - they don't run if the resource the depend on
//  is not available - anything where we work with something external not in our control
//  should use assumptions.
  @Test
  public void assumptionTest() {
    Assumptions.assumeTrue("prod".equals(System.getProperty("testenv")));
    contactManager.addContact("Tom", "Hardy", "0070070077");
    Assertions.assertFalse(contactManager.contactList.isEmpty());
  }

//  Repeated Tests - run the same test multiple times
  @RepeatedTest(value = 10)
  public void CheckIfNumberMatches(){
    int result = 5;
    Random rand = new Random();
    int num = rand.nextInt(10);
    System.out.println(num);
//    Assertions.assertTrue(result == num);
  }

//  Parameterized Tests

  /**
   * Multiple type source can be given
   * null, empty, nullEmptyAndBlank, methodSource
   * csvSource, csvFileSource
   */
  @ParameterizedTest
  @ValueSource(strings = {"racecar", "mom", "not"})
  public void testPalindrome(String word){
    Assertions.assertTrue(StringUtils.isNotBlank(word));
  }

  @ParameterizedTest
  @MethodSource("stringProvider") // can provide the string patterns through a method
  public void testPalindromeUsingStringProvider(String word){
    Assertions.assertTrue(StringUtils.isNotBlank(word));
  }

  @AfterAll()
  public static void cleanUp(){
    System.out.println("Clean up...");
  }

  static Stream<String> stringProvider(){
    return Stream.of("racecar", "takat", "outof");
  }

}