package com.example.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class RecursionTest {

  @Test
  public void recursiveSum_calculatesSumRecursively() {
    assertEquals(15 , Recursion.recursiveSum(5));
  }

  @Test
  public void recursiveSumWithParam_calculatesSumRecursively() {
    assertEquals(15 , Recursion.recursiveSumWithParam(5));
  }

  @Test
  public void fibonacci_calculateForNthMember() {
    assertEquals(0, Recursion.fibonacci(0));
    assertEquals(1, Recursion.fibonacci(1));
    assertEquals(1, Recursion.fibonacci(2));
    assertEquals(2, Recursion.fibonacci(3));
    assertEquals(21, Recursion.fibonacci(8));
  }

  @Test
  public void arrayMultiplication_multipliesAllElementsInArray() {
    assertEquals(1, Recursion.arrayMultiplication(new int[]{1}));
    assertEquals(6, Recursion.arrayMultiplication(new int[]{1,2,3}));
  }

  @Test
  public void isRecursivePalindrome() {
    assertTrue(Recursion.isRecursivePalindrome("madam"));
    assertTrue(Recursion.isRecursivePalindrome("maddam"));
    assertFalse(Recursion.isRecursivePalindrome("lady"));
    assertFalse(Recursion.isRecursivePalindrome("ladies"));
  }

  @Test
  public void reverseRecursively() {
    assertEquals("suiraM", Recursion.reverseRecursively("Marius"));
  }

  @Test
  public void reverseRecursively_WhenOnlyUsingOneFunction() {
    assertEquals("suiraM", Recursion.reverseInOneFunction("Marius"));
  }
}
