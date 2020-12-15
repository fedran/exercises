package org.fedran.stepic;

import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Deque;

/**
 * Напишите программу, которая прочитает из System.in последовательность
 * целых чисел, разделенных пробелами, затем удалит из них все числа, стоящие
 * на четных позициях, и затем выведет получившуюся последовательность в
 * обратном порядке в System.out.
 */

public class CollectionExercise {
    public static void printReverseCollection() {
        final Deque<String> deque = new ArrayDeque<>();
        final Scanner scanner = new Scanner("1 2 3 4 5 6 7");
        for (int i = 0; scanner.hasNext(); i++) {
            scanner.next();
            deque.addFirst(!scanner.hasNext() ? "" : scanner.next());
        }
        System.out.println(String.join(" ", deque));
    }
}

