package org.fedran.stepic;

import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

class PseudoRandomStreamTest {
    @Test
    public void test() {
        final IntStream intStream = PseudoRandomStream.pseudoRandomStream(13);
        final int[] array = {13, 16, 25, 62, 384, 745, 502, 200, 0, 0};
        final int[] resArray = intStream.limit(10).toArray();
        assertArrayEquals(array, resArray);
    }
}