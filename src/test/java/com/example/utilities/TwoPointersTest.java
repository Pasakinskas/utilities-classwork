package com.example.utilities;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
public class TwoPointersTest {


  @Test
  public void arrayContainsMultiplication() {
    assertTrue(TwoPointers.arrayContainsMultiplication(new int[]{9,8,7,4,3,1}, 24));
    assertFalse(TwoPointers.arrayContainsMultiplication(new int[]{9,7,4,3,1}, 24));
  }

  @Test
  public void rotate() {
    var input = new int[]{1,2,3,4,5,6,7,8,9,10,11};
    var result = new int[]{8,9,10,11,1,2,3,4,5,6,7};

    TwoPointers.rotate(input, 4);
    assertArrayEquals(result, input);
  }

  @Test
  public void rotateEven() {
    var input = new int[]{1,2,3,4,5,6,7,8,9,10};
    var result = new int[]{7,8,9,10,1,2,3,4,5,6};

    TwoPointers.rotate(input, 4);
    assertArrayEquals(result, input);
  }
}
