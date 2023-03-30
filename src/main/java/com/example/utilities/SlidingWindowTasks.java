package com.example.utilities;

import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class SlidingWindowTasks {

  public static int smallestSum(int[] numbers) {
    int smallestSum = Integer.MAX_VALUE;

    for (int i = 0; i < numbers.length - 3; i++) {
      int windowSum = Arrays.stream(Arrays.copyOfRange(numbers, i, i + 4)).sum();
      smallestSum = min(smallestSum, windowSum);
    }
    return smallestSum;
  }

  public static boolean isMistakeFixable(String first, String second) {

    boolean result = false;

    for (int i = 0; i < max(first.length(), second.length()); i++) {
      String firstLetter = getCharacterByIndex(first, i);
      String secondLetter = getCharacterByIndex(second, i);

      if (!firstLetter.equals(secondLetter)) {
        var firstWithAdditional = insertLetter(first, secondLetter, i);
        var secondWithAdditional = insertLetter(second, firstLetter, i);

        var firstWithReplaced = replaceLetter(first, secondLetter, i);
        var secondWithReplaced = replaceLetter(second, firstLetter, i);

        result = firstWithAdditional.equals(second)
          || secondWithAdditional.equals(first)
          || firstWithReplaced.equals(second)
          || secondWithReplaced.equals(first);
        break;
       }
    }

    return result;
  }

  private static String insertLetter(String recipient, String letter, int index) {
    return new StringBuilder(recipient)
      .insert(index, letter)
      .toString();
  }

  private static String replaceLetter(String recipient, String letter, int index) {
    var sb = new StringBuilder(recipient);
    try {
      return sb.replace(index,1, letter).toString();
    } catch (StringIndexOutOfBoundsException e) {
      return insertLetter(recipient, letter, index);
    }
  }

  private static String getCharacterByIndex(String input, int index) {
    try {
      return input.substring(index, index + 1);
    } catch (StringIndexOutOfBoundsException e) {
      return "";
    }
  }

  public static int[] repeatedCharacters(int[] numbers) {

    class Repeats {
      private int number;
      private int noOccurrences;
      private List<Integer> indexes;

      public Repeats(int number, int noOccurrences, int index) {
        this.number = number;
        this.noOccurrences = noOccurrences;
        this.indexes = new ArrayList<Integer>();

        indexes.add(index);
      }

      public int getNumber() {
        return number;
      }

      public void setNumber(int number) {
        this.number = number;
      }

      public int getNoOccurrences() {
        return noOccurrences;
      }

      public void setNoOccurrences(int noOccurrences) {
        this.noOccurrences = noOccurrences;
      }

      public List<Integer> getIndexes() {
        return indexes;
      }

      public void setIndexes(List<Integer> indexes) {
        this.indexes = indexes;
      }
    }

    var repeatingNumbers = new HashMap<Integer, Integer>();

    for (int i = 0; i < numbers.length - 2; i++) {
      var window = Arrays.copyOfRange(numbers, i, i + 3);
      var windowNumbers = new HashMap<Integer, Repeats>();

      for (int numberInWindow : window) {
        if (windowNumbers.containsKey(numberInWindow)) {
          var current = windowNumbers.get(numberInWindow);
          current.indexes.add(i);
          current.setNoOccurrences(current.getNoOccurrences() + 1);
        } else {
          windowNumbers.put(numberInWindow, new Repeats(numberInWindow, 1, i));
        }
      }

      windowNumbers.forEach((number, repeats) -> {
        if (repeats.noOccurrences > 1) {
          repeats.indexes.forEach(index -> repeatingNumbers.put(index, number));
        }
      });
    }

    return repeatingNumbers
      .values()
      .stream()
      .mapToInt(Integer::intValue)
      .toArray();
  }

  public static String findLongestSubstring(String input, int limit) {

    String longestSubstring = "";

    for (int windowStart = 0, windowEnd = 0; windowEnd <= input.length(); windowEnd++) {
      String slice = input.substring(windowStart, windowEnd);

      if (getUniqueLetterAmount(slice) > limit) {
        while (getUniqueLetterAmount(input.substring(windowStart, windowEnd)) > limit) {
          windowStart++;
        }
      } else {
        if (slice.length() > longestSubstring.length()) {
          longestSubstring = slice;
        }
      }
    }
    return longestSubstring;
  }

  private static int getUniqueLetterAmount(String slice) {
    return slice.chars()
      .mapToObj(e->(char)e)
      .collect(Collectors.toSet())
      .size();
  }
}
