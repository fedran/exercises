package org.fedran.olympiad;

import java.util.Scanner;

/**
 * В первой строке записано целое положительное число n (1 ≤ n ≤ 100) —
 * количество блоков, в которых записан файл.
 *
 * Во второй строке следует последовательность из n различных целых
 * положительных чисел a1, a2, ..., an (1 ≤ ai ≤ n), где ai-е равно
 * номеру блока файла, который расположен на жестком диске в позиции i от начала.
 *
 * Выведите количество перемещений считывающей головки жесткого диска,
 * чтобы прочитать весь файл целиком.
 *
 * Изначально считывающая головка расположена в начале жесткого диска
 * (то есть над самым левым из блоков в их записи во входных данных).
*/

public class FindPosition {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int[] array = new int[a];
        for (int i = 0; i < a; i++) {
            array[i] = scanner.nextInt();
        }

        int nextPosition, count = 0, position = 0;

        for (int i = 1; i <= a; i++) {
            nextPosition = findPosition(array, i);
            count += (Math.abs(position - nextPosition));
            position = nextPosition;
        }
        System.out.println(count);
    }

    private static int findPosition(int[] array, int block) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == block) return i;
        }
        return 0;
    }
}
