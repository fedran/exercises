package org.fedran.stepic;

 class CallerClassAndMethodName {
    public static String getCallerClassAndMethodName() {
        String s = Thread.currentThread().getStackTrace()[1].getMethodName();
        return s; // your implementation here
    }
}
