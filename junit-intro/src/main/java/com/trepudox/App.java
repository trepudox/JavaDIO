package com.trepudox;

import java.util.*;

public class App {
    public static void main(String[] args) {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        set1.addAll(Arrays.asList(1, 55, 42, 33, 2, 3, 4, 5, 999, 6, 7, 9999, 8, 9, 10));
        set2.addAll(Arrays.asList(1, 55, 42, 33, 2, 3, 4, 5, 999, 6, 7, 9999, 8, 9, 10));

        System.out.println(set1);
        System.out.println(set2);

        System.out.println("set1 == set2: " + (set1 == set2));
        System.out.println("set1.equals(set2): " + set1.equals(set2));

        Set<Integer> set3 = Set.copyOf(set1);
        System.out.println(set3);
    }
}
