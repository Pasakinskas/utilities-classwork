package com.example.functions;

import java.util.Arrays;
import java.util.function.Function;


public class FunctionExample {

  public static void main(String[] args) {
    var strings = Arrays.asList("one", "two", "three");
    Function<String, String> addLength = (input) -> input + "-" + input.length(); // one -> one-3
    Function<String, String> capitalize = (input) -> input.toUpperCase(); // one-3 -> ONE-3

    strings.stream()
      .map(addLength.andThen(capitalize))
      .forEach(System.out::println);

    strings.stream()
      .map(addLength)
      .map(capitalize)
      .forEach(System.out::println);
  }
}
