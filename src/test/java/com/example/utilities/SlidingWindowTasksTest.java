package com.example.utilities;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class SlidingWindowTasksTest {

  String input = "abcbdbdbbdcdabd";

  @Test
  public void findLongestSubstring_whenKIs2() {
    String result = SlidingWindowTasks.findLongestSubstring(input, 2);

    assertEquals("bdbdbbd", result);
  }

  @Test
  public void findLongestSubstring_whenKIs3() {
    String result = SlidingWindowTasks.findLongestSubstring(input, 3);

    assertEquals("bcbdbdbbdcd", result);
  }

  @Test
  public void findLongestSubstring_whenKIs5() {
    String result = SlidingWindowTasks.findLongestSubstring(input, 5);

    assertEquals("abcbdbdbbdcdabd", result);
  }

  @Test
  public void findSmallestSum() {
    int result = SlidingWindowTasks.smallestSum(new int[]{1,2,3,4,5,6,7,8,9,10});

    assertEquals(10, result);
  }

  @Test
  public void findSmallestSum_whenNumbersAreAtTheArrayEnd() {
    int result = SlidingWindowTasks.smallestSum(new int[]{5,6,7,8,9,10,1,2,3,4});

    assertEquals(10, result);
  }

  @Nested
  @DisplayName("equality is based on values")
  class repeatedCharacters {
    @Test
    public void repeatedCharacters_whenThereAreRepeatedCharacters() {
      int[] result = SlidingWindowTasks.repeatedCharacters(new int[]{5,5,3,4});

      assertArrayEquals(new int[]{5,5}, result);
    }

    @Test
    public void repeatedCharacters_whenThereAreNoRepeatedCharacters() {
      int[] result = SlidingWindowTasks.repeatedCharacters(new int[]{5,3,4});

      assertArrayEquals(new int[]{}, result);
    }

    @Test
    public void repeatedCharacters_whenThereAreSeveral() {
      int[] result = SlidingWindowTasks.repeatedCharacters(new int[]{5,5,3,4,0,4});

      assertArrayEquals(new int[]{5,5,4,4}, result);
    }

    @Test
    public void repeatedCharacters_whenThereAreManyNumbers() {
      int[] result = SlidingWindowTasks.repeatedCharacters(new int[]{5,5,5,5,3,4,0,4});

      assertArrayEquals(new int[]{5,5,5,5,5,4,4}, result);
    }
  }

  @Nested
  @DisplayName("equality is based on values")
  class IsMistakeFixable {
    @Test
    public void isMistakeFixable_whenMissingLetter() {
      boolean result = SlidingWindowTasks.isMistakeFixable("pale", "ple");

      assertTrue(result);
    }

    @Test
    public void isMistakeFixable_whenLetterNeedsReplacing() {
      boolean result = SlidingWindowTasks.isMistakeFixable("pale", "bale");

      assertTrue(result);
    }

    @Test
    public void isMistakeFixable_whenLetterNeedsRemoving() {
      boolean result = SlidingWindowTasks.isMistakeFixable("pales", "pale");

      assertTrue(result);
    }

    @Test
    public void isMistakeFixable_whenNotPossible() {
      boolean result = SlidingWindowTasks.isMistakeFixable("pale", "bake");

      assertFalse(result);
    }
  }
}
