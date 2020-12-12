package org.fedran.stepic;

import org.junit.jupiter.api.Test;

import static org.fedran.stepic.Roles.printTextPerRole;
import static org.junit.jupiter.api.Assertions.*;

class RolesTest {
    @Test
    public void printTextPerRoleTest() {
        final String roles = "Городничий\n" +
                "Аммос Федорович\n" +
                "Артемий Филиппович\n" +
                "Лука Лукич";
        final String textLines = "Городничий: Я пригласил вас, господа, " +
                "с тем, чтобы сообщить вам пренеприятное известие: " +
                "к нам едет ревизор.\n" +
                "Аммос Федорович: Как ревизор?\n" +
                "Артемий Филиппович: Как ревизор?\n" +
                "Городничий: Ревизор из Петербурга, инкогнито. " +
                "И еще с секретным предписаньем.\n" +
                "Аммос Федорович: Вот те на!\n" +
                "Артемий Филиппович: Вот не было заботы, так подай!\n" +
                "Лука Лукич: Господи боже! еще и с секретным предписаньем!";
        final String[] rolesSplit = roles.split("\n");
        final String[] textLinesSplit = textLines.split("\n");
        final String textPerRole = printTextPerRole(rolesSplit, textLinesSplit);
        final String outPut = "Городничий:\n" +
                "1) Я пригласил вас, господа, с тем, чтобы сообщить " +
                "вам пренеприятное известие: к нам едет ревизор.\n" +
                "4) Ревизор из Петербурга, инкогнито. " +
                "И еще с секретным предписаньем.\n" +
                "\n" +
                "Аммос Федорович:\n" +
                "2) Как ревизор?\n" +
                "5) Вот те на!\n" +
                "\n" +
                "Артемий Филиппович:\n" +
                "3) Как ревизор?\n" +
                "6) Вот не было заботы, так подай!\n" +
                "\n" +
                "Лука Лукич:\n" +
                "7) Господи боже! еще и с секретным предписаньем!";
        assertEquals(outPut, textPerRole);
    }
}