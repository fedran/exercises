package org.fedran.codewars;

public class Order {
    public static String order(String words) {
        String[] s = words.split(" ");
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            for (String s1 : s) {
                if (s1.contains(String.valueOf(i))) {
                    res.append(s1).append(" ");
                }
            }
        }
        return res.toString().trim();
    }
}