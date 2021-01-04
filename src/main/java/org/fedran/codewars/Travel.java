package org.fedran.codewars;

import java.util.Arrays;

public class Travel {
    public static String travel(final String r, final String zipcode) {
        if (zipcode.isBlank()) {
            return ":/";
        }
        if (r.isBlank()) {
            return zipcode + ":/";
        }
        final String[] addresses = r.split(",");
        if (addresses.length == 0) {
            return zipcode + ":/";
        }
        final StringBuilder res = new StringBuilder()
            .append(zipcode)
            .append(":/");
        Arrays.stream(addresses)
            .filter(address -> address.substring(address.length() - 8).equals(zipcode))
            .forEach(address -> {
                final String street = address.substring(address.indexOf(" ") + 1, address.length() - 9);
                res.insert(res.indexOf("/"), res.charAt(res.length() - 1) == '/' ? street : "," + street);
                final String houseNumber = address.substring(0, address.indexOf(" "));
                res.append(res.charAt(res.length() - 1) == '/' ? houseNumber : "," + houseNumber);
            });
        return res.toString();
    }
}
