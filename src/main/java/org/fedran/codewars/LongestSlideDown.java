package org.fedran.codewars;

public class LongestSlideDown {
    public static int longestSlideDown(int[][] pyramid) {
        if (pyramid.length == 0) {
            return -1;
        } else if (pyramid.length == 1) {
            return pyramid[0][0];
        }

        int[][] ways = toWays(pyramid.length);
        ways[0][0] = pyramid[0][0];

        for (int i = 0; i < ways.length - 1; i++) {
            int[] row = ways[i];
            for (int j = 0; j < row.length; j++) {
                ways[i + 1][j] = Math.max(ways[i + 1][j], ways[i][j] + pyramid[i + 1][j]);
                ways[i + 1][j + 1] = Math.max(ways[i + 1][j + 1], ways[i][j] + pyramid[i + 1][j + 1]);
            }
        }

        int max = 0;
        int[] last = ways[ways.length - 1];

        for (int value : last) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }

    public static int[][] toWays(int pyramidLength) {
        int[][] ways = new int[pyramidLength][];
        for (int i = 0; i < ways.length; i++) {
            ways[i] = new int[i + 1];
        }
        return ways;
    }

    public static int longestWay(int[][] pyramid, int x, int y, int weight) {
        if (pyramid.length == y + 1) {
            return weight + pyramid[y][x];
        }
        return Math.max(
                longestWay(pyramid, x, y + 1, weight + pyramid[y][x]),
                longestWay(pyramid, x + 1, y + 1, weight + pyramid[y][x])
        );
    }
}
