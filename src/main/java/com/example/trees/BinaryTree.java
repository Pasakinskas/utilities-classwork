package com.example.trees;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public abstract class BinaryTree<T> {
  public Node<T> root;

  static class Node<T> {
    private T data;
    private Node<T> left;
    private Node<T> right;

    public Node(T value) {
      this.data = value;
    }

    public T getData() {
      return data;
    }

    public void setData(T data) {
      this.data = data;
    }

    public Node<T> getLeft() {
      return left;
    }

    public Node<T> getRight() {
      return right;
    }
  }

  public abstract int compare(T data1, T data2);

  public abstract T sum();

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
    if (compare(value, current.data) < 1) {
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

  public boolean isBinaryTree() {
    var myValues = new ArrayList<T>();
    gatherValues(root, myValues);

    var cloned = new ArrayList<T>(myValues);
    cloned.sort(this::compare);

    return myValues.equals(cloned);
  }

  private void gatherValues(Node<T> current, List<T> container) {
    if (current != null) {
      gatherValues(current.left, container);
      container.add(current.data);
      gatherValues(current.right, container);
    }
  }

  public T max() {
    var current = root;
    while (current.right != null) {
      current = current.right;
    }
    return current.data;
  }
}
