package org.fedran.codewars;

public class Rainfall {
    public static double mean(String town, String string) {
        double[] nums = extractRain(town, string);
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        return sum / nums.length == 0 ? -1.0 : sum / nums.length;
    }

    public static double variance(String town, String string) {
        double[] nums = extractRain(town, string);
        double sum = 0;
        for (double num : nums) {
            sum += num;
        }
        double mean = (sum / nums.length);
        double vari = 0;
        for (double num : nums) {
            vari += Math.pow(num - mean, 2);
        }
        return vari / nums.length == 0 ? -1.0 : vari / nums.length;
    }

    private static double[] extractRain(String town, String data) {
        town += ":";
        double[] nums = new double[12];
        for (String s : data.split("\n")) {
            if (s.startsWith(town)) {
                s = s.substring(town.length());
                int i = 0;
                for (String month : s.split(",")) {
                    nums[i] = Double.parseDouble(month.substring(4));
                    i++;
                }
                break;
            }
        }
        return nums;
    }
}