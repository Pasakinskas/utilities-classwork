package com.example.trees;

/*
Turime nerūšiuotą skaičių array. Sukonstruokite iš jo Binary Search Tree.
 turėti metodą insert ir priimtų int[] numbers kaip argumentą.
 */

import java.util.Arrays;

public abstract class BinaryTree<T> {
  public Node<T> root;

  static class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
      this.data = value;
    }
  }

  /**
   * @return true, if data1 is smaller than data2
   */
  public abstract boolean compare(T data1, T data2);

  public void insertArray(T[] items) {
    Arrays.stream(items).forEach(this::insert);
  }

  public void insert(T value) {
    root = insertRecursively(root, value);
  }

  private Node<T> insertRecursively(Node<T> current, T value) {
    if (current == null) {
      current = new Node<T>(value);
      return current;
    }
    if (compare(value, current.data)) {
      current.left = insertRecursively(current.left, value);
    } else {
      current.right = insertRecursively(current.right, value);
    }

    return current;
  }

  public void printTreeValues(Node<T> current) {
    if (current != null) {
      System.out.println(current.data);
      printTreeValues(current.left);
      printTreeValues(current.right);
    }
  }
}
