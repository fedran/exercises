package org.fedran.codewars;

public class BouncingBall {
    public static int bouncingBall(double h, double bounce, double window) {
        int res = -1;

        if (!(h > 0)) {
            return res;
        }
        else if (!(bounce > 0 && bounce < 1)) {
            return res;
        }
        else if (!(window < h)) {
            return res;
        }
        while (h > window) {
            h = h * bounce;
            res += 2;
        }
        return res;
    }
}
