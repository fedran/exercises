package org.fedran.stepic;

import java.util.*;
import java.util.stream.Collectors;

public class CommonWordsProcessor {
    public static List<String> findCommonWords(final String input) {
        final Map<String, Integer> map = new TreeMap<>();
        final String[] words = input.toLowerCase(Locale.ROOT).split("[^A-Za-zА-Яа-я0-9]+");
        for (String word : words) {
            if (map.containsKey(word)) {
                map.replace(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(10)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }
}
