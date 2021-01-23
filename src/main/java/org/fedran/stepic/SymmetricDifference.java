package org.fedran.stepic;

import java.util.HashSet;
import java.util.Set;

public class SymmetricDifference {
    public static <T> Set<T> symmetricDifference(Set<? extends T> set1, Set<? extends T> set2) {
        final Set<T> res = new HashSet<>();
        set1.forEach(setItem -> res.add(set2.contains(setItem) ? null : setItem));
        set2.forEach(setItem -> res.add(set1.contains(setItem) ? null : setItem));
        res.remove(null);
        return res;
    }
}
