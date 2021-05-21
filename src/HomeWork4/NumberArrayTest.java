package HomeWork4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

public class NumberArrayTest {
    private static NumberArray numberArray;

    @BeforeAll
    static void init() {
        numberArray = new NumberArray();
    }

    @Test
    void when_in_arrayAfterNumber_no_number() {
        int[] a = new int[]{2, 3, 5};
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList());
        Assertions.assertEquals(expectedResult, numberArray.arrayAfterNumber(a));
    }

    @Test
    void when_in_arrayAfterNumber_number() {
        int[] a = new int[]{2, 4, 3, 5};
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(3, 5));
        Assertions.assertEquals(expectedResult, numberArray.arrayAfterNumber(a));
    }

    @Test
    void when_in_arrayAfterNumber_number_is_last() {
        int[] a = new int[]{2, 3, 5, 4};
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList());
        Assertions.assertEquals(expectedResult, numberArray.arrayAfterNumber(a));
    }

    @Test
    void when_in_arrayAfterNumber_several_numbers() {
        int[] a = new int[]{4, 3, 5, 4, 6};
        ArrayList<Integer> expectedResult = new ArrayList<>(Arrays.asList(6));
        Assertions.assertEquals(expectedResult, numberArray.arrayAfterNumber(a));
    }


    @Test
    void when_in_checkArray_numbers() {
        int[] a = new int[]{1, 1, 1, 4, 4, 1, 4, 4};
        Assertions.assertEquals(true, numberArray.checkArray(a));
    }

    @Test
    void when_in_checkArray_no_number_1() {
        int[] a = new int[]{ 4, 4, 4, 4, };
        Assertions.assertEquals(false, numberArray.checkArray(a));
    }

    @Test
    void when_in_checkArray_no_number_4() {
        int[] a = new int[]{1, 1, 1, 1, 1, 1};
        Assertions.assertEquals(false, numberArray.checkArray(a));
    }
    @Test
    void when_in_checkArray_else_number() {
        int[] a = new int[]{1, 4, 4, 1, 1, 4, 3};
        Assertions.assertEquals(false, numberArray.checkArray(a));
    }

}
