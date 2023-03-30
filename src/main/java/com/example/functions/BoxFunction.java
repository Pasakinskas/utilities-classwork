package com.example.functions;

import java.util.List;

@FunctionalInterface
public interface BoxFunction<T> {

  List<T> box(T t);
}
