package com.example.functions;

import java.util.function.Supplier;

public class SupplierExample {
  public static void main(String[] args) {
    addParamAndPrint(SupplierExample::getNumber, 5);
    addParamAndPrint(SupplierExample::getNumberDifferently, 5);
  }

  public static void addParamAndPrint(Supplier<Integer> fn, int param) {
    System.out.println(fn.get() + param);
  };

  static int getNumber() {
    return 10;
  }

  static int getNumberDifferently() {
    return 15;
  }
}
