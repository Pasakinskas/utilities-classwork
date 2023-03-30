package com.example.utilities;

public class MyLinkedList<T> {

  private Node<T> head;
  private Node<T> tail;

  static class Node<T> {

    T data;
    Node<T> next;

    Node(T data) {
      this.data = data;
      this.next = null;
    }
  }

  public static MyLinkedList<Integer> createLoopedLinkedList() {
    var linkedList = new MyLinkedList<Integer>();
    linkedList.insert(1);
    linkedList.insert(2);
    var third = linkedList.insertAndGetNode(3);
    linkedList.insert(4);
    linkedList.insert(5);

    linkedList.getTail().next = third;

    return linkedList;
  }

  public void insert(T data) {
    var newNode = new Node<T>(data);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
  }

  private Node<T> insertAndGetNode(T data) {
    var newNode = new Node<T>(data);

    if (head == null) {
      head = newNode;
    } else {
      tail.next = newNode;
    }
    tail = newNode;
    return newNode;
  }

  public T getNth(int nth) {
    var fast = head;
    var slow = head;

    for (int i = 1; i <= nth; i++) {
      fast = fast.next;
    }
    while (fast.next != null) {
      fast = fast.next;
      slow = slow.next;
    }
    return slow.data;
  }

  public Node<T> getTail() {
    return tail;
  }

  public boolean checkLoop() {
    Node first = head;
    Node second = head;

    while(first != null && first.next !=null) {

      first = first.next.next;
      second = second.next;

      if(first == second) {
        return true;
      }
    }

    return false;
  }
}
