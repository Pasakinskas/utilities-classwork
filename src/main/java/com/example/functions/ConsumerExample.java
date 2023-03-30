package com.example.functions;

import java.util.Arrays;
import java.util.function.Consumer;

public class ConsumerExample {

  public static void main(String[] args) {
    var strings = Arrays.asList("one", "two", "three");

    Consumer<String> printEntity = (input) -> System.out.println(input); //  T -> void

    strings.forEach(printEntity);

    printEntity.accept("Five");
  }
}
