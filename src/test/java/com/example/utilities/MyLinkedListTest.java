package com.example.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@ExtendWith(SpringExtension.class)
public class MyLinkedListTest {

  @Test
  public void whenCheckLoop_returnsFalseIfNoLoopExists() {
    var list = new MyLinkedList<Integer>();
    list.insert(1);
    list.insert(2);
    list.insert(3);

    assertFalse(list.checkLoop());
  }

  @Test
  public void whenCheckLoop_returnsTrueIfLoopExists() {
    var list = MyLinkedList.createLoopedLinkedList();

    assertTrue(list.checkLoop());
  }
}
