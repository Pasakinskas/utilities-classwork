package com.example.utilities;

import java.util.Arrays;


public class Recursion {

  /**
   * Parašykite rekursinę funkciją, kuri sumuoja skaicius iki paskutinio duotojo
   * recursiveSum(5) => 5 + 4 + 3 + 2 + 1  = 15
   */

  public static int recursiveSum(int number) {
    if (number == 0) {
      return 0;
    } else {
      return number + recursiveSum(number - 1);
    }
  }

  public static int recursiveSumWithParam(int number) {
    return recursiveSum(number, 0);
  }

  private static int recursiveSum(int number, int sum) {
    if (number == 0) {
      return sum;
    } else {
      return recursiveSum(number - 1, sum + number);
    }
  }

  /**
   * Parašykite rekursinę funkciją, kuri paima skaičių „n“ ir grąžina n-ąjį Fibonačio sekos skaičių.
   * 0 1 1 2 3 5 8 13 21
   * fibonacci(
   */

  public static int fibonacci(int nth) {
    if (nth <= 0) {
      return 0;
    } else if (nth == 1) {
      return 1;
    }
    return fibonacci(nth - 1) + fibonacci(nth - 2);
  }

  /**
   * Atpausdinkite visus elementus is saraso
   */

  public static void printAll(int[] arr) {
    System.out.println(arr[0]);
    if (arr.length == 1) {
      return;
    }
    int[] smallerArray = Arrays.copyOfRange(arr, 1, arr.length);
    printAll(smallerArray);
  }

  /**
   * Parašykite rekursinę funkciją, kuri paima skaičių array kaip įvestį ir grąžina visų sąraše esančių skaičių sandaugą.
   */

  public static int arrayMultiplication(int[] arr) {
    if (arr.length == 1) {
      return arr[0];
    } else {
      int[] smallerArray = Arrays.copyOfRange(arr, 1, arr.length);
      return arr[0] * arrayMultiplication(smallerArray);
    }
  }

  /**
   * Parašykite funkciją, kuri paima eilutę ir grąžinama, jei eilutė yra palindromas.
   */

  public static boolean isRecursivePalindrome(String word) {
    if (word.length() == 0 || word.length() == 1) {
      return true;
    } else {
      String first = word.substring(0, 1);

      int length = word.length();
      String last = word.substring(length - 1);

      if (!first.equals(last)) {
        return false;
      }
      return isRecursivePalindrome(word.substring(1, word.length() - 1));
    }
  }

  /**
   * Parašykite rekursinę funkciją, kuri paima eilutę (string) ir ją apsuka. (Marius -> siuraM)
   */

  public static String reverseRecursively(String input) {
    return reverseRecursively(input, "");
  }

  private static String reverseRecursively(String input, String result) {
    if (input.length() == 0) {
      return result;
    } else {
      String lastLetter = input.substring(input.length() - 1);
      String newResult = result + lastLetter;
      return reverseRecursively(input.substring(0, input.length() - 1), newResult);
    }
  }

  public static String reverseInOneFunction(String word) {
    if (word.length() == 0 || word.length() == 1) {
      return word;
    } else {
      return word.substring(word.length() - 1) + reverseRecursively(word.substring(0, word.length() - 1));
    }
  }
}
