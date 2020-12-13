package org.fedran.stepic;

/**
 * Дан список ролей и сценарий пьесы в виде массива строчек.
 * Каждая строчка сценария пьесы дана в следующем виде:
 * Роль: текст
 *
 * Текст может содержать любые символы.
 *
 * Написать метод, который будет группировать строчки по ролям, пронумеровывать
 * их и возвращать результат в виде готового текста.
 * Каждая группа распечатывается в следующем виде:
 *
 * Роль:
 * i) текст
 * j) текст2
 * ...
 * ==перевод строки==
 *
 * i и j -- номера строк в сценарии. Индексация строчек начинается с единицы,
 * выводить группы следует в соответствии с порядком ролей. Переводы строк
 * между группами обязательны.
 */
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
