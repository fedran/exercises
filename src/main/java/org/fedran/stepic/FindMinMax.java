package org.fedran.stepic;

import java.util.function.BiConsumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.Comparator;
import java.util.List;

/**
 * Напишите метод, находящий в стриме минимальный и максимальный элементы в соответствии порядком,
 * заданным Comparator'ом. Найденные элементы передайте в minMaxConsumer.accept(T min, T max).
 */

public class FindMinMax {

    public static <T> void findMinMax(
            final Stream<? extends T> stream,
            final Comparator<? super T> order,
            final BiConsumer<? super T, ? super T> minMaxConsumer
    ) {
        final List<? extends T> list = stream
                .sorted(order)
                .collect(Collectors.toList());
        if (list.isEmpty()) {
            minMaxConsumer.accept(null, null);
            return;
        }
        minMaxConsumer.accept(list.get(0), list.get(list.size() - 1));
    }
}
