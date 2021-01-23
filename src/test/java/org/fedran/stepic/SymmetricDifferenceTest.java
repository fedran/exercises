package org.fedran.stepic;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.fedran.stepic.SymmetricDifference.symmetricDifference;
import static org.junit.jupiter.api.Assertions.*;

class SymmetricDifferenceTest {
    @Test
    public void test() {
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        set1.add(4);
        set1.add(5);
        set2.add(3);
        set2.add(4);
        set2.add(5);
        set2.add(6);
        set2.add(7);
        final Set<Integer> res = symmetricDifference(set1, set2);
        assertTrue(res.contains(1));
        assertTrue(res.contains(2));
        assertTrue(res.contains(6));
        assertTrue(res.contains(7));
        assertFalse(res.contains(null));
    }
}
