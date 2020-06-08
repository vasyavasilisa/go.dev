package com.softswiss.go.dev;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

public class ArrayUtils {

    private ArrayUtils() {
    }

    public static Integer[] combine(Integer[] array1, Integer[] array2) {
        if (array1 == null && array2 != null) {
            return new TreeSet<>(Arrays.asList(array2)).toArray(new Integer[0]);
        } else if (array1 == null) {
            return null;
        } else if (array2 == null) {
            return new TreeSet<>(Arrays.asList(array1)).toArray(new Integer[0]);
        }
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(array1));
        treeSet.addAll(Arrays.asList(array2));
        return treeSet.toArray(new Integer[0]);
    }
}