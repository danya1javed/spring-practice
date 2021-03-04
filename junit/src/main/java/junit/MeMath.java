package junit;

import java.util.Arrays;
import java.util.List;

public class MeMath {
  static double sumall(double ... nums) {
    return Arrays.stream(nums).sum();
  }

  public static void main(String[] args) {
    System.out.println(MeMath.sumall(0.3, 0.7, 9, 2));
  }
}