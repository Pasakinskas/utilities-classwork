package com.example.utilities;

import java.util.Arrays;

public class TwoPointers {

  /**
   * Patikrinkite, ar mažėjimo tvarka išrūšiuotame array’juje yra du skaičiai, kurių sandauga yra lygi 25
   */

  public static boolean arrayContainsMultiplication(int[] arr, int number) {
    int i = 0;
    int j = arr.length - 1;

    while (i < j) {
      var result = arr[i] * arr[j];
      if (result == number) {
        return true;
      } else if(result > number) {
        i++;
      } else {
        j--;
      }
    }

    return false;
  }

  /**
   * Turime array, “pasukite” array K elementais, kuomet k nėra neigiamas.
   * pvz: mūsų įvestis yra [7, 8, 9, 10, 11, 12] ir k yra 4, tuomet išvestis yra [10, 11, 12, 7, 8, 9].
   */

  public static void rotate(int[] input, int step) {
    step %= input.length;
    System.out.println("infodump");
    System.out.println(Arrays.toString(input));
    reverse(input, 0, input.length - 1);
    System.out.println(Arrays.toString(input));
    reverse(input, 0, step - 1);
    System.out.println(Arrays.toString(input));
    reverse(input, step, input.length - 1);
    System.out.println(Arrays.toString(input));
  }

  private static void reverse(int[] input, int start, int end) {
    while (start < end) {
      int temp = input[start];
      input[start] = input[end];
      input[end] = temp;
      start++;
      end--;
    }
  }
}
