package org.fedran.stepic;

public class Roles {
    static String printTextPerRole(final String[] roles, final String[] textLines) {
        final StringBuilder textPerRole = new StringBuilder();
        for (String role : roles) {
            textPerRole.append("\n")
                    .append(role)
                    .append(":\n");
            for (int i = 0; i < textLines.length; i++) {
                if (textLines[i].startsWith(role.concat(":"))) {
                    textPerRole.append(i + 1)
                            .append(")")
                            .append(textLines[i].substring(role.length() + 1))
                            .append("\n");
                }
            }
        }
        return textPerRole.toString().trim();
    }
}
