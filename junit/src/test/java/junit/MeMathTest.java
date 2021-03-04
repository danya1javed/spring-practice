package junit;

import org.junit.jupiter.api.Test;
import org.junit.Assert;
import org.junit.jupiter.api.*;
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.assertEquals;

// DisplayName has higher priority then DisplayNameGeneration

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class MeMathTest {
  MeMath mathtest = new MeMath();

  @BeforeAll // runs once before this class tests begins
  static void beforeAll(){
    System.out.println("Starting Test Suite - Before All");
  }


  @AfterEach
  public void afterEachTest(){
    System.out.println("AfterEach - Running");
  }


  @Test
  @DisplayName("Checks for sum of multipe numbers - mixed double and integers")
  public void testMoreThanOneNum(){
    assertEquals(10, mathtest.sumall(1, 1, 1, 0.5, 0.5, 6));
//    Absence of failure is success.
//    fail("it failed.");
  }

  @Test
  public void testOneNum(){
    assertEquals(2, mathtest.sumall(2));
  }
  @Test
  public void testAllDouble(){
    assertEquals(3.5, mathtest.sumall(0.5,0.5,2.5));
  }
}
