package org.fedran.codewars;

import java.util.Arrays;

public class M2048 {
    static int[] merge(int[] line) {
        var res = shiftLeft(line);

        for (int i = 0; i + 1 < res.length; i++) {
            if (res[i] == res[i + 1]) {
                res[i] = res[i] * 2;
                res[i + 1] = 0;
            }
        }

        res = shiftLeft(res);
        System.out.println(Arrays.toString(res));
        System.out.println(Arrays.toString(line));
        return shiftLeft(res);
    }

    static int[] shiftLeft(int[] line) {
        int[] res = new int[line.length];
        int j = 0;
        for (int i : line) {
            if (i != 0) {
                res[j] = i;
                j++;
            }
        }
        return res;
    }
}
