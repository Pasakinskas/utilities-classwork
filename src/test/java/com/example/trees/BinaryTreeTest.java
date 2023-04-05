package com.example.trees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
public class BinaryTreeTest {

  @Test
  public void whenInsertArray_CreatesABinaryTreeFromArray() {
    Integer[] myArr = new Integer[]{5,15,45,10,3,2,999,12};
    BinaryTree<Integer> mytree = new BinaryTree<>() {

      @Override
      public boolean compare(Integer data1, Integer data2) {
        return data1 < data2;
      }
    };

    mytree.insertArray(myArr);

    mytree.printTreeValues(mytree.root);
  }
}
