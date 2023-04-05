package com.example.caesar;

import java.util.stream.Stream;

public class App {
  public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

  public static String encryptData(String input, int shiftKey) {
    input = input.toLowerCase();
    String encryptStr = "";

    for (int i = 0; i < input.length(); i++) {
      int pos = ALPHABET.indexOf(input.charAt(i));

      int encryptPos = (shiftKey + pos) % 26;
      char encryptChar = ALPHABET.charAt(encryptPos);

      encryptStr += encryptChar;
    }

    return encryptStr;
  }

  public static void main(String[] args) {
    encryptData("Hello", 2);
  }
}
