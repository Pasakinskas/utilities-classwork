package com.example.functions;

import java.util.Arrays;

public class RunnableExample {
  public static void main(String[] args) {
    var strings = Arrays.asList("one", "two", "three");

    Runnable printLine = () -> System.out.println("line");

    printString("hello", () -> System.out.println("---"));
  }

  static void printString(String input, Runnable separator) {
    separator.run();
    System.out.println(input);
    separator.run();
  }
}
