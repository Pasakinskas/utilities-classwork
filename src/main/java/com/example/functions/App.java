package com.example.functions;

import java.util.ArrayList;
import java.util.List;

public class App {
  public static void main(String[] args) {
    BoxFunction<Integer> boxer = (input) -> {
      var list = new ArrayList<Integer>();
      list.add(input);
      return list;
    };

    var myResult = multiplyAndBox(5, 5, boxer);
  }

  static List<Integer> multiplyAndBox(int a, int b, BoxFunction<Integer> boxFunction) {
    var result = a * b;
    return boxFunction.box(result);
  }
}
