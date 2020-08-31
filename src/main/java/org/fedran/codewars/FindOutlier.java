package org.fedran.codewars;

import java.util.function.Predicate;

import static java.lang.Math.abs;

public class FindOutlier {
    static int find(int[] integers) {
        int accum = abs(integers[0] % 2) + abs(integers[1] % 2) + abs(integers[2] % 2);
        if (accum < 2) {
            return findNum(integers, x -> x % 2 != 0);
        }
        return findNum(integers, x -> x % 2 == 0);
    }

    static int findNum(int[] ints, Predicate<Integer> predicate) {
        for (int anInt : ints) {
            if (predicate.test(anInt)) {
                return anInt;
            }
        }
        return 0;
    }
}