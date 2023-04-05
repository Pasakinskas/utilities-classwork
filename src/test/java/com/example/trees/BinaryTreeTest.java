package com.example.trees;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class BinaryTreeTest {

  @Test
  public void whenInsertArray_CreatesABinaryTreeFromArray() {
    var binaryTree = createBinaryTree();
  }

  @Test
  public void whenMax_ReturnsTheLargestValueFromThetree() {
    var binaryTree = createBinaryTree();

    assertEquals(999, binaryTree.max());
  }

  @Test
  public void whenSum_ReturnsTheTotalSum() {
    var binaryTree = createBinaryTree();

    assertEquals(1091, binaryTree.sum());
  }

  @Test
  public void whenIsBinaryTree_ReturnsTrueForABinaryTree() {
    var binaryTree = createBinaryTree();

    assertTrue(binaryTree.isBinaryTree());
  }

  @Test
  public void whenIsBinaryTree_ReturnsFalseForANonBinaryTree() {
    var binaryTree = createBinaryTree();
    binaryTree.root.getRight().setData(1);

    assertFalse(binaryTree.isBinaryTree());
  }



  static BinaryTree<Integer> createBinaryTree() {
    Integer[] myArr = new Integer[]{5,15,45,10,3,2,999,12}; //1091
    BinaryTree<Integer> mytree = new BinaryTree<Integer>() {

      @Override
      public int compare(Integer data1, Integer data2) {
        return data1 - data2;
      }

      public Integer sum() {
        return sum(root);
      }

      private int sum(Node<Integer> current) {
        if (current == null) {
          return 0;
        } else {
          return current.getData() + sum(current.getLeft()) + sum(current.getRight());
        }
      }
    };

    mytree.insertArray(myArr);
    return mytree;
  }
}
