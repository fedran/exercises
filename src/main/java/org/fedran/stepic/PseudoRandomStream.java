package org.fedran.stepic;

import java.util.stream.IntStream;

/**
 * Напиcать метод, возвращающий стрим псевдослучайных целых чисел. Алгоритм
 * генерации чисел следующий:
 *
 * 1. Берется какое-то начальное неотрицательное число (оно будет передаваться
 * в ваш метод проверяющей системой).
 * 2. Первый элемент последовательности устанавливается равным этому числу.
 * 3. Следующие элементы вычисляются по рекуррентной формуле
 * R(n+1) = mid(R^2(n)), где mid — это функция, выделяющая второй, третий и
 * четвертый разряд переданного числа. Например, mid(123456) = 345.
 */
public class PseudoRandomStream {
    public static IntStream pseudoRandomStream(final int seed) {
        return IntStream.iterate(seed, PseudoRandomStream::recurrentFormula);
    }

    public static int recurrentFormula(final int i) {
        final int pow = (int) Math.pow(i, 2);
        final String s = String.valueOf(pow);
        String res;
        if (s.length() <= 1) {
            return 0;
        } else if (s.length() == 2) {
            res = s.substring(s.length() - 2, s.length() - 1);
        } else if (s.length() == 3) {
            res = s.substring(s.length() - 3, s.length() - 1);
        } else {
            res = s.substring(s.length() - 4, s.length() - 1);
        }
        return Integer.parseInt(res);
    }
}
