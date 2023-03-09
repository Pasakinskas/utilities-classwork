package com.example.utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class UtilitiesTest {

  @Nested
  @DisplayName("isPalindrome")
  class IsPalindrome {
    @Test
    public void whenIsPalindrome_itReturnsTrueIfWordIsPalindrome() {
      var result = Utilities.isPalindrome("Taco cat");

      assertEquals(true, result);
    }

    @Test
    public void whenIsPalindrome_itReturnsFalseIfWordIsNotAPalindrome() {
      var result = Utilities.isPalindrome("Hello");

      assertEquals(false, result);
    }
  }

  @Nested
  @DisplayName("isUnique")
  class IsUnique {
    @Test
    public void whenIsUnique_itReturnsTrueIfAllCharactersInWordAreUnique() {
      var result = Utilities.isUnique("hi you!");

      assertTrue(result);
    }

    @Test
    public void whenIsUnique_itReturnsFalseIfCharactersAreNotUnique() {
      var result = Utilities.isUnique("hello!");

      assertFalse(result);
    }
  }

  @Nested
  @DisplayName("powerOf2")
  class powerOf2 {

    @Test
    public void whenPowerOfTwo_raisesBYThePowerOfTwo() {
      var input = List.of(1, 2, 3);
      var result = Utilities.powerOf2(input);

      assertAll(
        "power of two list",
        () -> assertEquals(1, result.get(0)),
        () -> assertEquals(4, result.get(1)),
        () -> assertEquals(9, result.get(2))
      );

      var actual = result.stream().mapToInt(Integer::intValue).toArray();
      assertArrayEquals(new int[]{1, 4, 9}, actual);
    }

    @Test
    public void whenPowerOfTwo_andListIsEmpty_itReturnsEmptyList() {
      var input = new ArrayList<Integer>();
      var result = Utilities.powerOf2(input);

      var actual = result.stream().mapToInt(Integer::intValue).toArray();
      assertArrayEquals(new int[]{}, actual);
    }
  }

  @Nested
  @DisplayName("powerOfN")
  class powerOfN {
    @Test
    public void whenPowerOfN_itReturnsTheNumberRaisedByThePower() {
      var result = Utilities.powerOfN(5, 2);

      assertEquals(25, result);
    }

    @Test
    public void whenPowerOfN_iReturns1IfPowerIsZero() {
      var result = Utilities.powerOfN(5, 0);

      assertEquals(1, result);
    }

    @Test
    public void whenPowerOfN_andPowerIsNegative_itThrows() {
      assertThrows(PowerCannotBeNegativeException.class, () -> Utilities.powerOfN(5, -1));
    }
  }
}