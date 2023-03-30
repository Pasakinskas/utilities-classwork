package com.example.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
public class MainTest {


  @Test
  public void longestSubstring() {
    var result = Main.findLongestSubstring("aaabcdeeeee");

    assertEquals("abcde", result);
  }
}
