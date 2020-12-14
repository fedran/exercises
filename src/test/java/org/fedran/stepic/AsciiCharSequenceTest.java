package org.fedran.stepic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AsciiCharSequenceTest {
    @Test
    public void test() {
        final byte[] example = {72, 101, 108, 108, 111, 33};
        final AsciiCharSequence answer = new AsciiCharSequence(example);
        final char e = 'e';
        assertEquals("Hello!", answer.toString());
        assertEquals(6, answer.length());
        assertEquals(e, answer.charAt(1));
        assertEquals("ello", answer.subSequence(1, 5).toString());
    }
}