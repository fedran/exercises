package org.fedran.stepic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CallerClassAndMethodNameTest {
    @Test
    public void test(){
        final String s = CallerClassAndMethodName.getCallerClassAndMethodName();
    }

    public static void main(String[] args) {
        System.out.println(getCallerClassAndMethodName());
        anotherMethod();
    }

    private static void anotherMethod() {
        System.out.println(getCallerClassAndMethodName());
    }

    public static String getCallerClassAndMethodName() {
        return Thread.currentThread().getStackTrace()[1].getMethodName();
    }
}