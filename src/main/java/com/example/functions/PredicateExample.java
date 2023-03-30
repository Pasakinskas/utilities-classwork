package com.example.functions;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateExample {

  public static void main(String[] args) {
    List<String> names = Arrays.asList("John", "Smith", "Samuel", "Catley", "Sie");
    Predicate<String> nameStartsWithS = str -> str.startsWith("S");
    Predicate<String> nameIsLongerThan4Characters = str -> str.length() > 4;

    var result = names.stream().filter(nameStartsWithS.and(nameIsLongerThan4Characters));
  }
}
