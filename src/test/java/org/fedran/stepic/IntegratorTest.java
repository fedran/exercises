package org.fedran.stepic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntegratorTest {
    @Test
    public void integrateTest() {
        final double a = Integrator.integrate(x -> 1, 0, 10);
        final double b = Integrator.integrate(x -> 1 / Math.log(x), 2, 5);
        assertEquals(10, a, 0.001);
        assertEquals(2.589, b, 0.001);
    }
}