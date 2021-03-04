package junit;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AnotherMathTest {
  @Test
  @DisplayName("Check square of two numbers")
  public void checkSquareOfTwoNumbers(){
    Assertions.assertEquals(4, 2*2); // just an example
  }
}
