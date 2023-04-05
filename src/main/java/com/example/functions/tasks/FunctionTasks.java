package com.example.functions.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class FunctionTasks {

  public static void main(String[] args) {
    var items = Arrays.asList("One", "Two", "Three");
    var result = mapRecursively(items, (one) -> one.toUpperCase());

    result.forEach(System.out::println);
  }

  static void benchmarkSlidingWindow() {
    var arr = Arrays.asList(1,2,3,4,5,6,7,11,13,19,25);

    Function<List<Integer>, Boolean> sumIteratively =
      (List<Integer> list) -> {
        for (int i = 0; i < list.size(); i++) {
          for (int j = 0; i < list.size(); i++) {
            if (i + j == 50) {
              return true;
            }
          }
        }
        return false;
      };

    Function<List<Integer>, Boolean> sumWithTwoPointers =
      (List<Integer> list) -> {
        int i = 0;
        int j = list.size() - 1;

        while (i < j) {
          var result = list.get(i) + list.get(j);
          if (result == 50) {
            return true;
          } else if(result > 50) {
            j--;
          } else {
            i++;
          }
        }

        return false;
      };

    var result = benchmark(sumIteratively, arr);
    var resultWithSlidingWIndow = benchmark(sumWithTwoPointers, arr);

    System.out.println(result);
    System.out.println(resultWithSlidingWIndow);
  }

  static <T,R> long benchmark(Function<T, R> fn, T list) {
    var before = System.nanoTime();
    fn.apply(list);
    var after = System.nanoTime();
    return after - before;
  }

  static void transform(List<String> strings) {
    Predicate<String> shorterThan5 = letter -> letter.length() < 5;
    Function<String, String> toUpperCase = letter -> letter.toUpperCase();
    Consumer<String> println = input -> System.out.println(input);

    strings.stream()
      .filter(shorterThan5)
      .map(toUpperCase)
      .forEach(println);
  }

  static <T,R> List<R> mapRecursively(List<T> input, Function<T, R> fn) {
    return mapRecursively(input, fn, new ArrayList<R>());
  }

  static <T,R> List<R> mapRecursively(List<T> input, Function<T, R> fn, List<R> result) {
    if (input.isEmpty()) {
      return result;
    }
    var value = fn.apply(input.get(0));
    result.add(value);

    return mapRecursively(input.subList(1, input.size()), fn, result);
  }
}

