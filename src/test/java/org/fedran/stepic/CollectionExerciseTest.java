package org.fedran.stepic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class CollectionExerciseTest {

    private final ByteArrayOutputStream baos = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        System.setOut(new PrintStream(baos));
    }

    @Test
    void test() {
        CollectionExercise.printReverseCollection();
        assertEquals("6 4 2", baos.toString().trim());
    }
}