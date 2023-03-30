package com.example.utilities;

import java.util.Set;
import java.util.stream.Collectors;

class Main {
  public static String findLongestSubstring(String str) {

    String longestSubstring = "";

    for (int low = 0, high = 0; high < str.length(); high++) {
      var slice = str.substring(low, high);

      if (!isUnique(slice)) {
        while (!isUnique(str.substring(low, high))) {
          low++;
        }
      } else {
        if (slice.length() > longestSubstring.length()) {
          longestSubstring = slice;
        }
      }
    }
    return longestSubstring;
  }

  private static boolean isUnique(String str) {
    Set<Character> charsSet = str.chars()
      .mapToObj(e-> (char)e )
      .collect(Collectors.toSet());

    return str.length() == charsSet.size();
  }
}