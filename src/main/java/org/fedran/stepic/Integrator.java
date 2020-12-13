package org.fedran.stepic;

import java.util.function.DoubleUnaryOperator;

/**
 * Реализовать метод, выполняющий численное интегрирование заданной функции
 * на заданном интервале по формуле левых прямоугольников.
 * <p>
 * Функция задана объектом, реализующим интерфейс
 * java.util.function.DoubleUnaryOperator. Его метод applyAsDouble()
 * принимает значение аргумента и возвращает значение функции в заданной точке.
 * <p>
 * Интервал интегрирования задается его конечными точками a и b,
 * причем a <= b. Для получения достаточно точного результата использовать
 * шаг сетки не больше 10^6.
 */
public class Integrator {
    static double integrate(final DoubleUnaryOperator f, final double a,
                            final double b) {
        final double n = 100000000;
        final double h = (b - a) / n;
        double res = 0;
        double count = a;
        while (count <= (b - h)) {
            res += h * f.applyAsDouble(count);
            count += h;
        }
        return res;
    }
}
