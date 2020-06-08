package com.softswiss.go.dev.tests.unit;

import com.softswiss.go.dev.ArrayUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;

public class ArrayUtilsTest {

    @Test
    public void testCombineShouldRemoveDuplicates() {
        Integer[] ar1 = {1, 2, 2};
        Integer[] ar2 = {3, 4, 4, 5};
        Integer[] expectedArr = {1, 2, 3, 4, 5};
        Integer[] actualArr = ArrayUtils.combine(ar1, ar2);
        Assert.assertEquals(expectedArr, actualArr, String.format("Array should not contain duplicates: expected %1$s, found %2$s",
                Arrays.toString(expectedArr), Arrays.toString(actualArr)));
    }

    @Test
    public void testCombineShouldSort() {
        Integer[] ar1 = {9, 5, 3};
        Integer[] ar2 = {1, 7, 4, 5};
        Integer[] expectedArr = {1, 3, 4, 5, 7, 9};
        Integer[] actualArr = ArrayUtils.combine(ar1, ar2);
        Assert.assertEquals(expectedArr, actualArr, String.format("Array should be sorted asc: expected %1$s, found %2$s",
                Arrays.toString(expectedArr), Arrays.toString(actualArr)));
    }

    @Test
    public void testCombineLeftNull() {
        Integer[] ar1 = null;
        Integer[] ar2 = {1, 2, 3};
        Integer[] expectedArr = {1, 2, 3};
        Integer[] actualArr = ArrayUtils.combine(ar1, ar2);
        Assert.assertEquals(expectedArr, actualArr, "Array should combine with first null");
    }

    @Test
    public void testCombineRightNull() {
        Integer[] ar1 = {1, 2, 3};
        Integer[] ar2 = null;
        Integer[] expectedArr = {1, 2, 3};
        Integer[] actualArr = ArrayUtils.combine(ar1, ar2);
        Assert.assertEquals(expectedArr, actualArr, "Array should combine with second null");
    }

    @Test
    public void testCombineBothNull() {
        Integer[] ar1 = null;
        Integer[] ar2 = null;
        Assert.assertNull(ArrayUtils.combine(ar1, ar2));
    }
}